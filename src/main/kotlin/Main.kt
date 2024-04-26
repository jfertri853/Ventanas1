import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState

fun main() {
    application {
        val mainWindowState = rememberWindowState()
        val secondWindowState = rememberWindowState()
        var showMainWindow by remember { mutableStateOf(true) }
        var showSecondWindow by remember { mutableStateOf(false) }

        if (!showMainWindow && !showSecondWindow) {
            exitApplication()
        }

        if (showMainWindow) {
            MainWindow(
                icon = BitmapPainter(useResource("shrek_icon.jpg", ::loadImageBitmap)),
                windowState = mainWindowState,
                onClose = { showMainWindow = false },
                onButtonClicked = {
                    showMainWindow = false
                    showSecondWindow = true
                }
            )
        }

        if (showSecondWindow) {
            SecondWindow(
                icon = BitmapPainter(useResource("shrek_icon.jpg", ::loadImageBitmap)),
                windowState = secondWindowState,
                onClose = { showSecondWindow = false },
                onButtonClicked = {
                    showSecondWindow = false
                    showMainWindow = true
                }
            )
        }
    }
}


@Composable
fun MainWindow(
    icon: BitmapPainter,
    windowState: WindowState,
    onClose: () -> Unit,
    onButtonClicked: () -> Unit
) {
    Window(
        onCloseRequest = onClose,
        title = "Ventana Principal",
        icon = icon,
        state = windowState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Contempla la mejor ventana de principal de la historia")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onButtonClicked) {
                Text("Ir a Ventana Secundaria")
            }
        }
    }
}


@Composable
fun SecondWindow(
    icon: BitmapPainter,
    windowState: WindowState,
    onClose: () -> Unit,
    onButtonClicked: () -> Unit
) {
    Window(
        onCloseRequest = onClose,
        title = "Ventana Secundaria",
        icon = icon,
        state = windowState
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bienvenido a la peor ventana secundaria de la historia")
            Spacer(modifier = Modifier.height(100.dp))
            Button(onClick = onButtonClicked) {
                Text("Ir a Ventana Principal")
            }
        }
    }
}