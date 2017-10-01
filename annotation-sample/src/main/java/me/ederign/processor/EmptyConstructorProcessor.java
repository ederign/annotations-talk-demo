package me.ederign.processor;

import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

//REMINDER: javax.annotation.processing.Processor
@SupportedAnnotationTypes({"javax.persistence.Entity"})
public class EmptyConstructorProcessor extends AbstractProcessor {

    private ElementTypePair entityType;
    private Messager messager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
        entityType = getType("javax.persistence.Entity");
    }

    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {

        Set<? extends Element> entityAnnotated =
                env.getElementsAnnotatedWith(entityType.getElement());
        for (TypeElement typeElement : ElementFilter.typesIn(entityAnnotated)) {
            checkForNoArgumentConstructor(typeElement);
        }

        return false; // let other processors work on these as well
    }

    private void checkForNoArgumentConstructor(TypeElement typeElement) {
        for (ExecutableElement constructor : ElementFilter.constructorsIn(typeElement.getEnclosedElements())) {
            List<? extends VariableElement> parameters = constructor.getParameters();
            if (parameters.isEmpty()) {
                return;
            }
        }
        AnnotationMirror entityAnnotation = getAnnotation(typeElement,
                                                          entityType.getType());
        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.ERROR,
                "sem construtor default",
                typeElement,
                entityAnnotation);
    }

    private void printWarning(String msg) {
        processingEnv.getMessager().printMessage(
                Diagnostic.Kind.WARNING,
                msg);
    }

    private ElementTypePair getType(String className) {
        TypeElement typeElement = processingEnv.getElementUtils().getTypeElement(className);
        DeclaredType declaredType = getTypeUtils().getDeclaredType(typeElement);
        return new ElementTypePair(typeElement,
                                   declaredType);
    }

    private Types getTypeUtils() {
        return processingEnv.getTypeUtils();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private AnnotationMirror getAnnotation(Element element,
                                           DeclaredType annotationType) {
        for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
            if (getTypeUtils().isSameType(mirror.getAnnotationType(),
                                          annotationType)) {
                return mirror;
            }
        }
        return null;
    }
}