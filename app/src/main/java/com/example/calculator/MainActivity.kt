package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var first_num: String = ""
        var second_num: String = ""
        var operation: String = ""

        btn_zero.setOnClickListener{
            setTextFields("0")
        }
        btn_one.setOnClickListener{setTextFields("1")}
        btn_two.setOnClickListener{setTextFields("2")}
        btn_three.setOnClickListener{setTextFields("3")}
        btn_four.setOnClickListener{setTextFields("4")}
        btn_five.setOnClickListener{setTextFields("5")}
        btn_six.setOnClickListener{setTextFields("6")}
        btn_seven.setOnClickListener{setTextFields("7")}
        btn_eight.setOnClickListener{setTextFields("8")}
        btn_nine.setOnClickListener{setTextFields("9")}

        btn_minus.setOnClickListener{

            try{
                if (first_num == "" || math_operation.text.toString().indexOf("-", 1) == -1 || math_operation.text.toString().length <= 12) {
                    first_num = math_operation.text.toString()
                    setTextFields("-")
                    Log.d("Message", "num1 = ${first_num}")
                }
                else if(math_operation.text.toString().length > 12){
                    //
                }
                else {
                    var op_pos: Int = math_operation.text.toString().indexOf("-", 1)
                    if (first_num.substring(first_num.length - 1) != "-"){
                        first_num += "-"
                    }
                    second_num = math_operation.text.substring(op_pos + 1, math_operation.text.length)
                    Log.d("Message", "num1 = ${first_num} num2 = ${second_num}")
                    stringBilder(first_num, second_num)
                    first_num = math_operation.text.toString()
                    second_num = ""
                    setTextFields("-")
                    Log.d("Message", "num1 = ${first_num} num2 = ${second_num}, op_pos = ${op_pos}")
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
                math_operation.text = "Вы ввели слишком большое число"
            }

        }
        btn_plus.setOnClickListener{setTextFields("+")}
        btn_exp.setOnClickListener{setTextFields("^")}
        btn_multiply.setOnClickListener{setTextFields("*")}
        btn_div.setOnClickListener{setTextFields("/")}

        //сброс
        btn_ac.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
            first_num = ""
            second_num = ""
        }
    }
    fun setTextFields(str: String){
        math_operation.append(str)
    }
    fun stringBilder(str_1: String, str_2: String){
        var num_2: Int = str_2.toInt()
        var move: Char = str_1[str_1.length - 1]
        var num_1: Int = str_1.substring(0, str_1.length - 1).toInt()
        Log.d("Message", "num1 = ${num_1}, num2 = ${num_2}, operation = ${move}")
        if (move == '-'){
            math_operation.text = (num_1-num_2).toString()
        }
        else if(move == '+'){

        }
    }
}