package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var premium: Int = 0
            var extra: Int = 0
            var total: Int = 0
            var isMale: Boolean = false
            //position 0..n-1
            val age = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            if(gender == binding.radioButtonMale.id){
                //calculate extra premium for males
                isMale = true
            }

            if(age == 0){//less than 17
                premium = 60
            }else if(age == 1){//17 to 25
                premium = 70
                if(isMale){
                    extra += 50
                }
                if(smoker){
                    extra += 100
                }
            }else if(age == 2){//26 to 30
                premium = 90
                if(isMale){
                    extra += 100
                }
                if(smoker){
                    extra += 150
                }
            }else if(age == 3){//31 to 40
                premium = 120
                if(isMale){
                    extra += 150
                }
                if(smoker){
                    extra += 200
                }
            }else if(age == 4){//41 to 55
                premium = 150
                if(isMale){
                    extra += 200
                }
                if(smoker){
                    extra += 250
                }
            }else if(age == 5){//more than 55
                premium = 150
                if(isMale){
                    extra += 200
                }
                if(smoker){
                    extra += 300
                }
            }


            total = premium + extra
            binding.myPremium = Premium(premium, extra, total)
        }

        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false

            binding.myPremium = Premium(0, 0, 0)
        }
    }
}