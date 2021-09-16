package vizcarra.leobardo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        btn0.setOnClickListener{appendOnExpression("0",true)}
        btn1.setOnClickListener{appendOnExpression("1",true)}
        btn2.setOnClickListener{appendOnExpression("2",true)}
        btn3.setOnClickListener{appendOnExpression("3",true)}
        btn4.setOnClickListener{appendOnExpression("4",true)}
        btn5.setOnClickListener{appendOnExpression("5",true)}
        btn6.setOnClickListener{appendOnExpression("6",true)}
        btn7.setOnClickListener{appendOnExpression("7",true)}
        btn8.setOnClickListener{appendOnExpression("8",true)}
        btn9.setOnClickListener{appendOnExpression("9",true)}

        //Operadores
        btnMas.setOnClickListener{appendOnExpression("+",false)}
        btnMenos.setOnClickListener{appendOnExpression("-",false)}
        btnPor.setOnClickListener{appendOnExpression("*",false)}
        btnEntre.setOnClickListener{appendOnExpression("/",false)}

        btnClr.setOnClickListener{tvExpresion.text=""
        tvResultado.text=""}

        btnEnter.setOnClickListener{
            try {

                val expression = ExpressionBuilder(tvExpresion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble()){
                    tvResultado.text = longResult.toString()
                }else{
                    tvResultado.text = result.toString()
                }

            }catch (e:Exception){
                Log.d("Exception","message" + e.message)
            }
        }

    }

    fun appendOnExpression(string: String, canClear:Boolean){

        if (tvResultado.text.isNotEmpty()){
            tvExpresion.text= ""
        }

        if (canClear){
            tvResultado.text=""
            tvExpresion.append(string)
        }else{
            tvExpresion.append(tvResultado.text)
            tvExpresion.append(string)
            tvResultado.text=""
        }
    }

}
