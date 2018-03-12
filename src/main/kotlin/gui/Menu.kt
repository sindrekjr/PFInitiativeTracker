package gui

import javafx.application.Platform
import tornadofx.*

class Menu : View() {
    override val root = menubar {
        menu("File") {
            item("New...", "Shortcut+N").action {

            }
            item("Load", "Shortcut+L").action {

            }
            item("Save", "Shortcut+S").action {

            }
            separator()
            item("Exit").action {
                Platform.exit()
            }
        }
    }
}
