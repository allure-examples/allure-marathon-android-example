package allure.example.marathon

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val incrementButton = KButton { withId(R.id.increment) }
    val decrementButton = KButton { withId(R.id.decrement) }
    val clearButton = KButton { withId(R.id.clear) }

    val valueText = KTextView {withId(R.id.counter)}
}
