package com.example.country_projectexample.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.country_projectexample.CountriesDetail
import com.example.country_projectexample.R
import com.example.country_projectexample.databinding.ItemCountryBinding


// <viewBinding 적용 버전>
class Recyclerview_Adapter(val context: Context, private var item: ArrayList<Recyclerview_Model>
) : RecyclerView.Adapter<Recyclerview_Adapter.ViewHolder>(), Filterable {

    val unfilterList = item //필터링을 하지 않은 원본 데이터 ArrayList를 한 개 만들어 놓는다.
    var filterList = item //원본 데이터를 복사한 필터링 데이터 ArrayList를 한 개 만들어 놓는다.

    /*
        항목에 사용할 View를 생성함
        ViewHodler가 생성되는 함수
        return 값으로 ViewHoler의 생성자에 view 객체를 넘겨준다.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(inflatedView)
    }

    /*
        생성된 ViewHolder에 데이터를 바인딩(연결) 해주는 함수이다.

        리사이클러뷰 아이템 View에 직접 데이터를 넣는 부분이다.
        여기서 햇갈리지 않아야 하는 부분은 item인데, item은 필터링 데이터 ArrayList이다.
        즉, 필터링 데이터 ArrayList를 ViewHolder를 통해 view를 연결해준 곳에 데이터를 넣는 곳이다.(모든 데이터가 들어있는 원본데이터가 아니라)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filterList[position]

        holder.name_Kor.text = item.korName_Common
        holder.name_Eng.text = item.enName_Official
        holder.capital.text = item.capital

        Glide.with(context)
            .load(item.flags)
            .into(holder.imageView)

        holder.imageView.setOnClickListener {

            val intent = Intent(context, CountriesDetail::class.java)
            intent.putExtra("enName_Common","${item.enName_Common}") //enName_Common
            intent.putExtra("enName_Official","${item.enName_Official}")
            intent.putExtra("korName_Common","${item.korName_Common}")
            intent.putExtra("flag","${item.flags}")

            intent.run { context.startActivity(this) }
        }
    }

    /*
        아이템의 개수를 가져온다.
        나는 커스텀을 하여 return 값으로 필터링 데이터 ArrayList의 개수를 가져온다.
     */
    override fun getItemCount(): Int {
        return filterList.size
    }

    /*
        View를 보관하며 View를 재활용한다.(원래 각 뷰의 내용을 업데이트 하기 위해선 findViewById가 계속 호출이 되야 하는데 이것을 최소화하기 위해 사용됨)
        즉, 각 아이템이 보여질 때마다 inflate되는 것을 최소화하여 성능을 높이기 위해 ViewHodel에 View를 저장하여 사용한다.
        *inflate : xml에 기술된 View의 정의를 실제 View 객체로 만드는 것
        화면에 보이게 되는 아이템만을 inflate시켜 메모리 효율성을 높인다.
        예를들어, 실제로 모두 보여지게 될 데이터 ArrayList의 사이즈가 100이라고 치면, 어쨌든 한 화면 5개 까지만의 데이터를 표현할 수 밖에 없다.
        이때 실제로 만들어지는 리스트는 100이 아니라 화면에 보여지는 개수인 5개만 만들어진다는 것이다. ==> ListView와 비교했을 때 효율성 극대화
        요약하자면, ViewHolder는 ListView/RecyclerView를 구현할 때 성능향상을 목적으로 View를 재사용하는 객체(방법)이다.
     */
    class ViewHolder(binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        val name_Kor = binding.nameKor
        val name_Eng = binding.nameEng
        val capital = binding.capital
        val imageView = binding.imageView
    }

    /*
    SearchBar를 만들기 위해 안드로이드에서 제공하는 Filterable 인터페이스를 implemetation 했다. 그러기 위해선 getFilter()라는 메서드를 오버라이드하여 구현해야한다.
    getFilter()함수를 통해 Filter() 클래스를 return 해야 한다. 이때 Filter 클래스는 추상(abstract)클래스로 정의되어 있다.
    추상 클래스를 object 키워드를 사용하여 바로 return 값으로 인스턴스화해서 넣어준다. 이때 구현해야하는 메소드는 performFiltering(), publishResults()이다.
     */
    override fun getFilter(): Filter {
        return object : Filter() {
            /*
                performFiltering()함수는 이름 그대로 필터링을 수행하는 함수이다.
                즉, 필터링을 수행하는 루프를 이 함수에 구현한 다음, 필터링된 결과 리스트를 FilterResults에 담아 리턴하면 된다.

                여기서 charSequence 변수는 내가 입력한 Char(값)라고 생각하면 편하다.
                results 변수는 FilterResults 를 인스턴스화 시켜준 값이라고 생각하면 편하다.
             */
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterString = charSequence.toString()
                val results = FilterResults()
                Log.d("Recyclerview", "charSequence: $charSequence")

                /*
                    1. 만약 filterString가 비어있다면(입력하지 않았다면)
                    ==> filterList는 필터링되지 않은 원본 데이터 ArrayList인 unfilterList의 값을 치환한다.(원본 값 그대로라 변함이 없음)
                    2. 만약 filterString이 비어있지않다면(입력했다면)
                    ==> 새로운 filteringList 변수 데이터 ArrayList 를 만들어주는데, 이것은 입력할 때 검색에 알맞는 리스트들을 집어넣기 위한 용도로 쓰이는 변수이다.
                    그렇기에 검색할때마다 새로운 값이 되어야 하기때문에 val를 통해 계속 초기화를 해주는 것이다.
                    필터링 로직은 원본데이터를 for문을 돌려 모든 값을 검색을 한다.
                    이때 filterString가 korName_Common(한국나라이름) or enName_Official(영어나라이름)의 값을 포함한다면 해당하는 데이터 index의 value 값을 filteringList에 추가시켜준다.
                    최종적으로 filterList에 filteringList의 값을 치환시켜준다.(필터링 된 값으로 치환되어서 filterList에는 필터링된 값만 들어감)
                    그 후 result의 vlaues 값에 최종 값인 filterList를 넣어주고 return 값으로 result를 넣어준다.
                 */
                filterList = if (filterString.isEmpty()) {
                    unfilterList
                } else {
                    val filteringList = ArrayList<Recyclerview_Model>()
                    for (item in unfilterList) {
                        Log.d("Recyclerview", "enName_Official: ${item?.enName_Official}")
                        if (item.korName_Common?.contains(filterString) == true || item.enName_Official?.toUpperCase()?.contains(filterString.toUpperCase()) == true) {
                            filteringList.add(item)
                        }
                    }
                    filteringList
                }
                results.values = filterList
                return results
            }

            /*
                publishResults()함수는 필터링된 결과를 UI에 갱신시키는 역할을 수행한다.
                즉, 커스텀 Adapter를 통한 RecyclerView 갱신 작업을 구현하면 된다.
             */
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(charSequence: CharSequence?, filterResults: Filter.FilterResults?) {

                filterList = filterResults?.values as ArrayList<Recyclerview_Model>
                notifyDataSetChanged()
            }
        }
    }
}


