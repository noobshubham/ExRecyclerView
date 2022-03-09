package com.noobshubham.exrecyclerview

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noobshubham.exrecyclerview.databinding.FragmentFirstBinding
import org.w3c.dom.Text

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // step 6 : final step
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = NameAdapter(requireActivity(), getStudentNames())
        binding.recyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getStudentNames(): List<String> {
        val nameList = listOf<String>(
            "Rohit Rai",
            "Abhishek Sahu",
            "Chandan Tripathi",
            "Desh Raj",
            "Durga Rajbhar",
            "Nikhlesh Sinha",
            "Shubham Yadav",
            "Sumeet Kumar Gupta",
            "Rajat Tomar",
            "Digvijay Singh",
            "Priyanshu Kesari",
            "Happy Singh",
            "Akash Verma",
            "Ayush Srivastava",
            "Adarsh Sahu",
            "Juheb Khan",
            "Pratima",
            "Neha",
            "Subhadra Upadhyay",
            "Khushbu Yadav",
            "Manisha Kumari Vishwakarm",
            "Harpreet Singh",
            "Ujjawal Shukla",
            "Manoj Tiwari",
            "Yashi Saxena",
            "Ashindra Dwivedi",
            "Naushad Ahmad",
            "Komal Gautam",
            "Ravi Sharma",
            "Mohd Salman",
            "Ambuj Srivastava",
            "Shweta Pandey"
        )
        return nameList
    }

    class NameAdapter(private val context: Context, private val nameList: List<String>) :
        RecyclerView.Adapter<NameAdapter.NameHolder>() {
        class NameHolder(private val view: View) : RecyclerView.ViewHolder(view) {
            val studentName: TextView = view.findViewById(R.id.student_name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
            val layout =
                LayoutInflater.from(context).inflate(R.layout.single_row_students, parent, false)
            return NameHolder(layout)
        }

        override fun onBindViewHolder(holder: NameHolder, position: Int) {
            val name = nameList[position]
            holder.studentName.text = name
        }

        override fun getItemCount() = nameList.size
    }
}