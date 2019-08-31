package teluniv.abdulmughni.jurnal_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.main_activity.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        btnOne.setOnClickListener { appendOnExpresstion("1", true) }
        btnTwo.setOnClickListener { appendOnExpresstion("2", true) }
        btnThree.setOnClickListener { appendOnExpresstion("3", true) }
        btnFour.setOnClickListener { appendOnExpresstion("4", true) }
        btnFive.setOnClickListener { appendOnExpresstion("5", true) }
        btnSix.setOnClickListener { appendOnExpresstion("6", true) }
        btnSeven.setOnClickListener { appendOnExpresstion("7", true) }
        btnEight.setOnClickListener { appendOnExpresstion("8", true) }
        btnNine.setOnClickListener { appendOnExpresstion("9", true) }
        btnZero.setOnClickListener { appendOnExpresstion("0", true) }
        btnPlus.setOnClickListener { appendOnExpresstion("+", false) }
        btnMinus.setOnClickListener { appendOnExpresstion("-", false) }
        btnMultiplication.setOnClickListener { appendOnExpresstion("*", false) }
        btnDivide.setOnClickListener { appendOnExpresstion("/", false) }
        btnDel.setOnClickListener {
            val string = tvInput.text.toString()
            if (string.isNotEmpty()) {
                tvInput.text = string.substring(0, string.length - 1)
            }
            tvOutput.text = ""
        }
        btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvInput.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvOutput.text = longResult.toString()
                else
                    tvOutput.text = result.toString()
            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if (tvOutput.text.isNotEmpty()) {
            tvInput.text = ""
        }

        if (canClear) {
            tvOutput.text = ""
            tvInput.append(string)
        } else {
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }

}




//        tvClear.setOnClickListener {
//            tvExpression.text = ""
//            tvResult.text = ""
//        }

