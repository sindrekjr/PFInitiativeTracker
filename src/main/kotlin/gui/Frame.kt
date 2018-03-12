package gui

import tornadofx.*

class Frame : View("Initiative Tracker") {
    override val root = borderpane {
        primaryStage.height = 500.0
        primaryStage.width = 800.0

        top(Menu::class)
    }

    /*init {
        root += button {

        }
        root += label {

        }
    }*/
}
