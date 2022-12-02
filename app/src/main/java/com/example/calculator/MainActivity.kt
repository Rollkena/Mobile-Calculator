package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor


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
        btn_dot.setOnClickListener{setTextFields(".")}

        btn_minus.setOnClickListener{

            try{
                operation = "-"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }



                //var text: String = math_operation.text.toString()
                //if(!text[text.length-1].isDigit()){
                //    math_operation.text = text.substring(0, text.length - 1);
                //}
                //if (first_num == "" || math_operation.text.toString().indexOf("-", 1) == -1) {
                //    if(math_operation.text.toString().length <= 12){
                //        first_num = math_operation.text.toString()
                //        setTextFields("-")
                //        Log.d("Message", "num1 = ${first_num}")
                //    }
                //    else if(math_operation.text.toString().length > 12){
                //        math_operation.text = "Вы ввели слишком большое число."
                //        result_text.text = ""
                //        first_num = ""
                //        second_num = ""
                //    }
                //}
                //else {
                //    var op_pos: Int = math_operation.text.toString().indexOf("-", 1)
                //    if (first_num.substring(first_num.length - 1) != "-"){
                //        first_num += "-"
                //    }
                //    second_num = math_operation.text.substring(op_pos + 1, math_operation.text.length)
                //    Log.d("Message", "num1 = ${first_num} num2 = ${second_num}")
                //    stringBilder(first_num, second_num)
                //    first_num = math_operation.text.toString()
                //    second_num = ""
                //    setTextFields("-")
                //    Log.d("Message", "num1 = ${first_num} num2 = ${second_num}, op_pos = ${op_pos}")
                //}
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        btn_plus.setOnClickListener{
            try {
                operation = "+"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        btn_exp.setOnClickListener{
            try {
                operation = "^"
                if (first_num == ""){
                    first_num = math_operation.text.toString()
                    math_operation.text = ""
                }
                else{
                    second_num = math_operation.text.toString()
                    stringBilder(first_num, second_num, operation)
                    first_num = result_text.text.toString()
                    math_operation.text = ""
                }
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //
        btn_multiply.setOnClickListener{setTextFields("*")}
        //деление
        btn_div.setOnClickListener{setTextFields("/")}
        //кнопка равно
        btn_equal.setOnClickListener{
            try{
                second_num = math_operation.text.toString()
                stringBilder(first_num, second_num, operation)
                first_num = result_text.text.toString()
                math_operation.text = ""
            }
            catch (e:Exception){
                Log.d("Error.","Сообщение: ${e.message}")
            }
        }
        //сброс AC
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
    fun stringBilder(str_1: String, str_2: String, str_operation: String){
        var num_1: Double = str_1.toDouble()
        var num_2: Double = str_2.toDouble()
        Log.d("Message", "num1 = ${num_1}, num2 = ${num_2}, operation = ${str_operation}")
        if (str_operation == "-"){
            result_text.text = (num_1-num_2).toString()
        }
        else if(str_operation == "+"){
            result_text.text = (num_1+num_2).toString()
        }
        else if(str_operation == "^"){
            for (i in 0 until floor(num_2).toInt()) {
                num_1 *= num_2
            }
            result_text.text = (num_1).toString()
        }
    }
}