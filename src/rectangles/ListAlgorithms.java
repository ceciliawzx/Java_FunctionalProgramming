package rectangles;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAlgorithms {

  /**
   * Returns a new list of rectangles by translating (moving) each rectangle according to the given
   * distance vector.
   *
   * @param rectangles The rectangles to be translated
   * @param vector The distance vector
   * @return The translated rectangles
   */
  public static List<Rectangle> translate(List<Rectangle> rectangles, Point vector) {
    List<Rectangle> res = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      Point new_topLeft = rectangle.getTopLeft().add(vector);
      res.add(new Rectangle(new_topLeft, rectangle.getWidth(), rectangle.getHeight()));
    }
    return res;
  }

  /**
   * Returns a new list of rectangles by scaling each rectangle by a given amount.
   *
   * @param rectangles The rectangles to be scaled
   * @param factor A non-negative scale factor
   * @return The scaled rectangles
   */
  public static List<Rectangle> scale(List<Rectangle> rectangles, int factor) {
    List<Rectangle> res = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      res.add(new Rectangle(rectangle.getTopLeft(),
              rectangle.getWidth() * factor,
              rectangle.getHeight() * factor));
    }
    return res;
  }

  /** Returns a list containing, in order, the bottom-left point of each input rectangle. */
  public static List<Point> getBottomLeftPoints(List<Rectangle> rectangles) {
    List<Point> res = new ArrayList<>();
    for (Rectangle rectangle : rectangles) {
      res.add(rectangle.getBottomLeft());
    }
    return res;
  }

  /**
   * Returns a list containing all rectangles that intersect with the given rectangle.
   *
   * @param rectangles A list of rectangles to be checked for intersection
   * @param rectangle The rectangle against which intersection should be checked
   * @return All rectangles that do intersect with the given rectangle
   */
  public static List<Rectangle> getAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {
    List<Rectangle> res = new ArrayList<>();
    for (Rectangle rec : rectangles) {
      if (rectangle.intersects(rec)) {
        res.add(rec);
      }
    }
    return res;
  }

  /**
   * Returns a list containing all rectangles with a bigger area than the given rectangle.
   *
   * @param rectangles A list of rectangles whose area is to be checked
   * @param rectangle The rectangle against which areas are to be compared
   * @return All rectangles that have a larger area than the given rectangle
   */
  public static List<Rectangle> getAllWithBiggerAreaThan(
      List<Rectangle> rectangles, Rectangle rectangle) {
    List<Rectangle> res = new ArrayList<>();
    for (Rectangle rec : rectangles) {
      if (rec.area() > rectangle.area()) {
        res.add(rec);
      }
    }
    return res;
  }

  /** Returns the largest area among the given rectangles. */
  public static int findLargestArea(List<Rectangle> rectangles) {
    int s = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.area() > s) {
        s = rectangle.area();
      }
    }
    return s;
  }

  /** Returns the largest height among all the given rectangles. */
  public static int findMaxHeight(List<Rectangle> rectangles) {
    int h = 0;
    for (Rectangle rectangle : rectangles) {
      if (rectangle.getHeight() > h) {
        h = rectangle.getHeight();
      }
    }
    return h;
  }

  /** Computes the sum of areas of all the given rectangles. */
  public static int getSumOfAreas(List<Rectangle> rectangles) {
    int s = 0;
    for (Rectangle rectangle : rectangles) {
        s += rectangle.area();
    }
    return s;
  }

  /**
   * Computes the sum of areas of all rectangles that intersect with the given rectangle.
   *
   * @param rectangles The rectangles whose areas to be considered and summed
   * @param rectangle The rectangle with which intersection is to be checked
   * @return The sum of areas of all rectangles that do intersect with the given rectangle
   */
  public static int getSumOfAreasOfAllIntersecting(
      List<Rectangle> rectangles, Rectangle rectangle) {
    int s = 0;
    for (Rectangle rec : rectangles) {
      if (rectangle.intersects(rec)) {
        s += rec.area();
      }
    }
    return s;
  }

  /** Returns collection that maps each rectangle to its computed area. */
  public static Map<Rectangle, Integer> getAreaMap(List<Rectangle> rectangles) {
    Map<Rectangle, Integer> map = new HashMap<>();
    for (Rectangle rectangle : rectangles) {
      map.put(rectangle, rectangle.area());
    }
    return map;
  }
}
