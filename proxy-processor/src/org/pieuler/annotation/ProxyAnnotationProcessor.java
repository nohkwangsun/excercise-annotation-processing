package org.pieuler.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@SupportedAnnotationTypes("org.pieuler.annotation.Proxy")
@SupportedSourceVersion(SourceVersion.RELEASE_18)
public class ProxyAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Test Proxy Annotation Processor: Noh Kwangsun");
        List<String> names = new ArrayList<>();
        for (Element element : roundEnv.getElementsAnnotatedWith(Proxy.class)) {
            names.add(element.getSimpleName().toString());
        }


        String className = "ProxyBuilder";
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Test Proxy Annotation Processor e: " + className);
        try (BufferedWriter writer = new BufferedWriter(processingEnv.getFiler().createSourceFile(className).openWriter())) {
            writer.append("package org.pieuler.domain;");
            writer.newLine();
            writer.append("public class " + className + " {");
            writer.newLine();
            writer.append("    public static <T> T builder(Class<T> clazz) {");
            writer.newLine();
            for (String name : names) {
                writer.append("        if (clazz.isAssignableFrom(" + name + ".class)) {");
                writer.newLine();
                writer.append("            return clazz.cast(new " + name + "());");
                writer.newLine();
                writer.append("        }");
                writer.newLine();
            }
            writer.append("        throw new RuntimeException(\"Unsupported Type\");");
            writer.newLine();
            writer.append("    }");
            writer.newLine();
            writer.append("}");
            writer.newLine();
            writer.flush();
        } catch (FilerException e) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Test Proxy Annotation Processor FilerException: " + e.getMessage());
        } catch (IOException e) {
            new RuntimeException(e);
        }
        return false;
    }
}
