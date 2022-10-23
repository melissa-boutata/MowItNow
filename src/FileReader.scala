import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
 * cette classe permet delire le fichier en entrée qui gère les tondeuses en initialisant les différents attributs des tondeuses.
 */
class FileReader {
  val source = Source.fromFile("./test.txt").getLines.toList
  println("Contenu du fichier de test en entrée:")
  for (line <- source) println(line)
      /* Récupération des coordonnées du coin supérieur droit de la pelouse, */
      var x_sup = source(0).split(" ")(0).toInt
      var y_sup = source(0).split(" ")(1).toInt

      /* Stockage des positions initiales des différentes tondeuses, ainsi que leurs orientations */
      var positions_initiales = new ListBuffer[String]()

      /* Stockage des listes d'instructions des différentes tondeuses */
      var instructions = new ListBuffer[String]()

      source.zipWithIndex.foreach { case (line, index) =>
        if (index % 2 != 0 && index != 0) positions_initiales += line
        if (index % 2 == 0 && index != 0) instructions += line
      }
}