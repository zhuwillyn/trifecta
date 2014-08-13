package com.ldaniels528.verify.vscript

/**
 * Represents a runtime execution scope
 * @author lawrence.daniels@gmail.com
 */
trait Scope {

  /**
   * Adds a new class to the scope
   */
  def +=(c: ClassDef): Scope

  /**
   * Attempts to retrieve a class from the scope
   */
  def getClassDef(name: String): Option[ClassDef]

  /**
   * Retrieves all classes from the scope
   */
  def getClassDefs: Seq[ClassDef]

  /**
   * Adds a new function to the scope
   */
  def +=(f: Function): Scope

  /**
   * Attempts to retrieve a function from the scope
   */
  def getFunction(name: String): Option[Function]

  /**
   * Retrieves all functions from the scope
   */
  def getFunctions: Seq[Function]

  /**
   * Adds a new variable to the scope
   */
  def +=(v: Variable): Scope

  /**
   * Attempts to retrieve a variable from the scope
   */
  def getVariable(name: String): Option[Variable]

  /**
   * Retrieves all variables from the scope
   */
  def getVariables: Seq[Variable]

  /**
   * Searches the scope hierarchy for an entity matching the given name
   */
  def getNamedEntity(name: String): Option[NamedEntity]

  /**
   * Returns all named entities within the scope
   */
  def getNamedEntities: Seq[NamedEntity]

}

/**
 * Represents a named entity
 * @author lawrence.daniels@gmail.com
 */
trait NamedEntity {

  /**
   * Returns the name of the entity
   * @return the name of the entity
   */
  def name: String

}

/**
 * Represents a class definition
 * @author lawrence.daniels@gmail.com
 */
case class ClassDef(name: String, params: Seq[String], code: OpCode) extends NamedEntity {
  override def toString = s"$name(${params mkString ", "})"
}

/**
 * Represents a function definition
 * @author lawrence.daniels@gmail.com
 */
case class Function(name: String, params: Seq[String], code: OpCode) extends NamedEntity {
  override def toString = s"$name(${params mkString ", "})"
}

/**
 * Represents a variable definition
 * @author lawrence.daniels@gmail.com
 */
case class Variable(name: String, var value: OpCode) extends NamedEntity {
  override def toString = s"$name = $value"
}

