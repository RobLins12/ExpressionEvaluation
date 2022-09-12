package br.unicap.ed1.challenge04;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluationTest {

  @Test
  public void test01() {
    Random r = new Random();
    Double number = r.nextDouble();
    String[] expression = {number.toString()};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = number;
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test02() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    String[] expression = {"(", n1.toString(), "+", n2.toString(), ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 + n2;
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test03() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    String[] expression = {"(", n1.toString(), "-", n2.toString(), ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 - n2;
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test04() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    String[] expression = {"(", n1.toString(), "*", n2.toString(), ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 * n2;
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test05() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    String[] expression = {"(", n1.toString(), "/", n2.toString(), ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 / n2;
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }
  
  @Test
  public void test06() {
    Random r = new Random();
    Double n = r.nextDouble();
    String[] expression = {"(", "sqrt", n.toString(), ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = Math.sqrt(n);
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test07() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    Double n3 = r.nextDouble();

    String[] expression = {"(", n1.toString(), "+","(",n2.toString(),"*",n3.toString(), ")", ")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 + (n2 * n3);
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

  @Test
  public void test08() {
    Random r = new Random();
    Double n1 = r.nextDouble();
    Double n2 = r.nextDouble();
    Double n3 = r.nextDouble();
    Double n4 = r.nextDouble();
    Double n5 = r.nextDouble();

    String[] expression = {"(", n1.toString(), "+","(","(",n2.toString(),"+",n3.toString(), ")","*","(",n4.toString(),"*",n5.toString(),")",")",")"};
    ExpressionEvaluation expressionEvaluation =  new ExpressionEvaluation(expression);
    Double expected = n1 + ((n2 + n3) * (n4 * n5));
    Double actual = expressionEvaluation.evaluate();
    Assertions.assertEquals(expected, actual, 0.0001);
  }

}
