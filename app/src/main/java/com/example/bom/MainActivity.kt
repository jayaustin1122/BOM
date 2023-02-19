package com.example.bom

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ListAdapter
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bom.databinding.AboutAppBinding
import com.example.bom.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var adapter : com.example.bom.ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = arrayListOf<Data>(
        Data ("Salaries and Wages-Regular Pay", "5-01-01-010"),
        Data ("Salaries and Wages Casual/Contractual", "5-01-01-020"),
        Data ("Personnel Economic Relief Allowance (PERA)", "5-01-02-010"),
        Data ("Representation Allowance (RA)", "5-01-02-020"),
        Data ("Transportation Allowance (TA)", "5-01-02-030"),
        Data ("Clothing Allowance", "5-01-02-040"),
        Data ("Subsistence Allowance", "5-01-02-050"),
        Data ("Laundry Allowance", "5-01-02-060"),
        Data ("Quarters Allowance", "5-01-02-070"),
        Data ("Productivity Allowance", "5-01-02-080"),
        Data ("Overseas Allowance", "5-01-02-090"),
        Data ("Honoraria", "5-01-02-100"),
        Data ("Hazard Pay", "5-01-02-110"),
        Data ("Longevity Pay", "5-01-02-120"),
        Data ("Overtime and Night Pay", "5-01-02-130"),
        Data ("Year End Bonus", "5-01-02-140"),
        Data ("Cash Gift", "5-01-02-150"),
        Data ("Other Bonuses and Allowances", "5-01-02-990"),
        Data ("Retirement and Life Insurance Premiums", "5-01-03-010"),
        Data ("PAG-IBIG Contributions", "5-01-03-020"),
        Data ("PHILHEALTH Contributions", "5-01-03-030"),
        Data ("Employees Compensation Insurance Premiums", "5-01-03-040"),
        Data ("Employees Compensation Insurance Premiums", "5-01-03-040"),
        Data ("Provident/Welfare Fund Contributions Pension Benefits", "5-01-03-050"),
        Data ("Pension Benefits", "5-01-04-010"),
        Data ("Retirement Gratuity", "5-01-04-020"),
        Data ("Terminal Leave Benefits", "5-01-04-030"),
        Data ("Other Personnel Benefits", "5-01-04-990"),
        Data ("Traveling Expenses-Local", "5-02-01-010"),
        Data ("Traveling Expenses-Foreign", "5-02-01-020"),
        Data ("Training Expenses", "5-02-02-010"),
        Data ("Scholarship Grants", "5-02-02-020"),
        Data ("Office Supplies Expenses", "5-02-03-010"),
        Data ("Accountable Forms Expenses", "5-02-03-020"),
        Data ("Non - Accountable Forms Expenses", "5-02-03-030"),
        Data ("Animal/Zoological Supplies Expenses", "5-02-03-040"),
        Data ("Food Supplies Expenses", "5-02-03-050"),
        Data ("Welfare Goods Expenses", "5-02-03-060"),
        Data ("Drugs and Medicines Expenses", "5-02-03-070"),
        Data ("Medical/Dental & Laboratory Supplies Expenses", "5-02-03-080"),
        Data ("Fuel, Oil &Lubricants Expenses", "5-02-03-090"),
        Data ("Agricultural & Marine Supplies Expenses", "5-02-03-100" ),
        Data ("Textbooks & Instructional Materials Expenses Other Supplies & Materials Expenses", "5-02-03-110"),
        Data ("Chemical& Filtering Supplies Expenses", "5-02-03-130"),
        Data ("Other Supplies & Materials Expenses", "5-02-03-990"),
        Data ("Electricity Expenses", "5-02-04-020"),
        Data ("Postage and Courier Expenses", "5-02-05-010"),
        Data ("Telephone Expenses", "5-02-05-020"),
        Data ("Internet Subscription Expenses", "5-02-05-030"),
        Data ("Cable, Satellite, Telegraph & Radio Expenses", "5-02-05-040"),
        Data ("Awards/Rewards Expenses", "5-02-06-010"),
        Data ("Prizes", "5-02-06-020"),
        Data ("Survey Expenses", "5-02-07-010"),
        Data ("Research, Exploration & Dev. Expenses", "5-02-07-020"),
        Data ("Demolition & Relocation Expenses", "5-02-08-010"),
        Data ("Desilting and Dredging Expenses", "5-02-08-020"),
        Data ("Generation, Transmission & Distribution Expenses", "5-02-09-010"),
        Data ("Confidential Expenses", "5-02-10-010"),
        Data ("Intelligence Expenses", "5-02-10-020"),
        Data ("Extraordinary and Miscellaneous Expenses", "5-02-10-030"),
        Data ("Legal Services", "5-02-11-010"),
        Data ("Auditing Services", "5-02-11-020"),
        Data ("Consultancy Services", "5-02-11-030"),
        Data ("Other Professional Services", "5-02-11-990"),
        Data ("Environment/Sanitary Services", "5-02-12-010"),
        Data ("Janitorial Services", "5-02-12-020"),
        Data ("Security Services", "5-02-12-030"),
        Data ("Other General Services", "5-02-12-990"),
        Data ("Repairs and Maintenance - Land Improvement", "5-02-13-020"),
        Data ("Repairs and Maintenance - Infrastructure Assets", "5-02-13-030"),
        Data ("Repairs and Maintenance - Building & Other Structure", "5-02-13-040"),
        Data ("Repairs and Maintenance - Machinery & Equipment", "5-02-13-050"),
        Data ("Repairs and Maintenance - Transportation Equipment", "5-02-13-060"),
        Data ("Repairs and Maintenance Furniture & Fixtures", "5-02-13-070"),
        Data ("Repairs and Maintenance - Leased Assets", "5-02-13-080"),
        Data ("Repairs and Maintenance - Leased Assets Improvements", "5-02-13-090"),
        Data ("Repairs and Maintenance- Other Prop. Plant & Equipt.", "5-02-13-990"),
        Data ("Subsidies Others", "5-02-14-990"),
        Data ("Taxes, Duties & Licenses", "5-02-15-010"),
        Data ("Fidelity Bond Premium", "5-02-15-020"),
        Data ("Insurance Expenses", "5-02-15-030"),
        Data ("Labor and Wages", "5-02-16-010"),
        Data ("Advertising Expenses", "5-02-99-010"),
        Data ("Printing & Publication Expenses", "5-02-99-020"),
        Data ("Representation Expenses", "5-02-99-030"),
        Data ("Transportation & Delivery Expenses", "5-02-99-040"),
        Data ("Rent/Lease Expenses", "5-02-99-050"),
        Data ("Membership Dues & Contributions to Organization", "5-02-99-060"),
        Data ("Subscription Expenses", "5-02-99-070"),
        Data ("Donations", "5-02-99-080"),
        Data ("Litigations/Acquired Assets Expenses", "5-02-99-090"),
        Data ("Other Maintenance and Operating Expenses", "5-02-99-990"),


        )
        list.sortBy{
            it.title
        }
        binding.searchEt2.clearFocus()
        //put value witch is productlist variable
        adapter = ListAdapter(list)
        binding.searchEt2.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchList = ArrayList<Data>()

                if (newText!=null){
                    for (i in list){
                        if (i.title.lowercase(Locale.ROOT).contains(newText)){
                            searchList.add(i)
                        }
                    }
                    if (searchList.isEmpty()){
                        Toast.makeText(this@MainActivity,"No data found",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        adapter.onApplySearch(searchList)
                    }
                }
                return true
            }

        })
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.tvBtnAboutApp.setOnClickListener {
            openDialogAbout()
        }
        adapter.onItemClick = {
            val intent = Intent(this, Onclicked::class.java)
            intent.putExtra("title",it.title)
            intent.putExtra("code",it.code)
            Toast.makeText(this, it.title,Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }



    private fun openDialogAbout() {
        val dialog = Dialog(this)
        val binding : AboutAppBinding = AboutAppBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()
    }


}