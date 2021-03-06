package de.uni.bielefeld.sc.hterhors.psink.obie.ontology.owl2javabin.builder;

import java.util.Set;
import java.util.stream.Collectors;

import de.uni.bielefeld.sc.hterhors.psink.obie.ontology.owl2javabin.enums.EAccessType;
import de.uni.bielefeld.sc.hterhors.psink.obie.ontology.owl2javabin.java.JavaConstructor;
import de.uni.bielefeld.sc.hterhors.psink.obie.ontology.owl2javabin.java.JavaField;

public class ConstructorBuilder {
	
	public JavaConstructor emptyConstructor(String className, final Set<JavaField> fields) {
		EAccessType accessType = EAccessType.PUBLIC;
		Set<JavaField> finalFields = fields.stream().filter(f -> f.isFinal() && f.getInitialization() == null)
				.collect(Collectors.toSet());
		boolean initializeNull = true;
		return new JavaConstructor(initializeNull, false, accessType, className, finalFields);
	}

	public JavaConstructor semanticValueConstructor(String className, final Set<JavaField> fields) {
		EAccessType accessType = EAccessType.PUBLIC;
		Set<JavaField> finalFields = fields.stream().filter(f -> f.isFinal() && f.getInitialization() == null)
				.collect(Collectors.toSet());
		boolean initializeNull = true;
		return new JavaConstructor(initializeNull, true, accessType, className, finalFields);
	}

	public JavaConstructor generateFinalFieldsConstructor(String className, final Set<JavaField> fields) {
		EAccessType accessType = EAccessType.PUBLIC;
		Set<JavaField> finalFields = fields.stream().filter(f -> f.isFinal() && f.getInitialization() == null)
				.collect(Collectors.toSet());

		boolean initializeNull = false;

		return new JavaConstructor(initializeNull, false, accessType, className, finalFields);
	}

	public JavaConstructor cloneConstructor(String className, Set<JavaField> fields) {
		EAccessType accessType = EAccessType.PUBLIC;
		Set<JavaField> nonStaticFields = fields.stream().filter(f -> !f.isStatic())
				.collect(Collectors.toSet());
		return new JavaConstructor(false, false, accessType, className, nonStaticFields, true);
	}

}
