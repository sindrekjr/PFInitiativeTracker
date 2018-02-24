package gui

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import tornadofx.*

class TrackerApplication : App(Frame::class) {
    init {
        FX.layoutDebuggerShortcut = KeyCodeCombination(KeyCode.F1)
    }
}