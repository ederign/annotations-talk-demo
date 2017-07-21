package me.ederign.processor;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

//@SupportedAnnotationTypes({"me.ederign.processor.PrintMe"})
public class PrintMeProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {
        Messager messager = processingEnv.getMessager();

        for (TypeElement te : annotations) {

            for (Element e : env.getElementsAnnotatedWith(te)) {
                messager.printMessage(Diagnostic.Kind.WARNING,
                                      "Printing: " + e.toString());
            }

        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<String>() {{
            add(PrintMe.class.getCanonicalName());
        }};
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}