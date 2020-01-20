package com.rakuten.training;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class CreateCircleTest {

  @Test
  public void testBuildCircleTest() {
    // fail("Not yet implemented");
    // Arrange
    CreateCircle objUnderTest = new CreateCircle();
    // Act
    List<Circle> circles = objUnderTest.buildCircle();
    // Assert
    assertNotNull(circles);
  }

  @Test
  public void removeSmallCircles_removes_small_circles_if_present() {
    // Arrange
    CreateCircle objectUnderTest = new CreateCircle();
    List<Circle> param = new ArrayList<Circle>();
    param.add(new Circle(1.0));
    param.add(new Circle(0.75));
    param.add(new Circle(0.5));
    param.add(new Circle(0.4));
    int original_size = param.size();
    int expectedsize = original_size - 1;
    // Act
    objectUnderTest.changeCircle(param);
    // Assert
    int actualsize = param.size();
    assertEquals(expectedsize, actualsize);
  }

  @Test
  public void removeSmallCircles_removes_Nothing_if_Absent() {
    // Arrange
    CreateCircle objectUnderTest = new CreateCircle();
    List<Circle> param = new ArrayList<Circle>();
    param.add(new Circle(1.0));
    param.add(new Circle(0.75));
    param.add(new Circle(0.5));
    param.add(new Circle(0.8));
    int original_size = param.size();
    int expectedsize = original_size;
    // Act
    objectUnderTest.changeCircle(param);
    // Assert
    int actualsize = param.size();
    assertEquals(expectedsize, actualsize);
  }
}
