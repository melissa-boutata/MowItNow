object Main {
  def main(args: Array[String]): Unit = {
    var Reader = new FileReader()

    var positions_initiales = Reader.positions_initiales.toList
    var instructions = Reader.instructions.toList
    /* Compteur pour but d'affichage du numéro de tondeuse */
    var cpt = 1

    /* Création d'une boucle pour créer autant de tondeuses existantes dans le fichier ( 2 dans notre cas ) */
    for ((i,j) <- positions_initiales zip instructions){
      var Tondeuse  = new Tondeuse(Reader.x_sup, Reader.y_sup, i.split(" ")(0).toInt, i.split(" ")(1).toInt,i.split(" ")(2), j.split("").toList)

      /* Execution de la méthode ExecuterInstruction() qui lit la liste des instructions de chaque tondeuse */
      Tondeuse.ExecuterInstruction()
      var x_finale=Tondeuse.x_courant
      var y_finale= Tondeuse.y_courant
      var oriantation_finale = Tondeuse.orientation

      /* Affichage de la position finale de chaque tondeuse */
      println(s"Position finale de la tondeuse $cpt: $x_finale $y_finale $oriantation_finale")
      cpt+=1
    }
  }
}