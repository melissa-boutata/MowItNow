/**
 * cette classe permet de créer une tondeuse
 * @constructor permet de créer une tondeuse.
 * @param x_max,y_max qui sont les limites supérieuses de la pelouse, x et y qui sont les positions courantes de la tondeuse, orientation
 * et instructions qui est uné liste d'instruction de la tondeuse */
class Tondeuse (var x_max: Int, var y_max: Int, var x: Int, var y: Int, var orientation: String, var instructions: List[String]) {
   var x_courant= x
   var y_courant = y

  /**
   * permet de lire les instructions de la tondeuse et de les éxecuter une à une
   */
  def ExecuterInstruction(): Unit ={
    for (i <- instructions){
      try{
        if( i == "A") this.Avancer()
        else if ( i == "D") this.Droite()
        else if( i == "G") this.Gauche()
      }
      catch{
        case ex: Exception => println("Mauvaise instruction.")
      }
    }
  }


  /**
   * permet d'avancer la tondeuse dans la pelouse sans changer d'orientation.
   */
  def Avancer(): Unit ={
    if (orientation== "N" && y_courant < y_max ) y_courant+=1
    else if (orientation== "S" && y_courant > 0 ) y_courant-=1
    else if (orientation== "W" && x_courant > 0 ) x_courant-=1
    else if (orientation== "E" && x_courant < x_max ) x_courant+=1
    else orientation=orientation
  }

  /**
   * permet de tourner la tondeuse de 90° à gauche sans la déplacer.
   */
  def Gauche(): Unit = {
    if (orientation == "N") orientation = "W"
    else if (orientation == "S") orientation = "E"
    else if (orientation == "E") orientation = "N"
    else if (orientation == "W") orientation = "S"
    else orientation=orientation
  }

   /**
   * permet de tourner la tondeuse de 90° à droite sans la déplacer.
   */
  def Droite(): Unit = {
    if (orientation == "N") {orientation = "E"}
    else if (orientation == "S") {orientation = "W"}
    else if (orientation == "E") {orientation = "S"}
    else if (orientation == "W") {orientation = "N"}
    else orientation=orientation
  }
}
