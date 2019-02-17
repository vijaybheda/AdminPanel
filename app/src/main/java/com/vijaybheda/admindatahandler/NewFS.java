package com.vijaybheda.admindatahandler;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class NewFS extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextName, editTextDOB;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fs);
        setTitle("Add FS Details");


        String[] listOfCities = {"Achalpur","Achhnera","Adalaj","Adilabad","Adityapur","Adoni","Adoor", "Adra","Adyar","Afzalpur","Agartala","Agra","Ahmedabad","Ahmednagar","Aizawl","Ajmer","Akola","Akot","Alappuzha","Aligarh","AlipurdUrban Agglomerationr","Alirajpur","Allahabad","Alwar","Amalapuram","Amalner","Ambejogai","Ambikapur","Amravati","Amreli","Amritsar","Amroha","Anakapalle","Anand","Anantapur","Anantnag","Anjangaon","Anjar","Ankleshwar","Arakkonam","Arambagh","Araria","Arrah","Arsikere","Aruppukkottai","Arvi","Arwal","Asansol","Asarganj","Ashok Nagar","Athni","Attingal","Aurangabad","Aurangabad","Azamgarh","Bagaha","Bageshwar","Bahadurgarh","Baharampur","Bahraich","Balaghat","Balangir","Baleshwar Town","Ballari","Balurghat","Bankura","Bapatla","Baramula","Barbil","Bargarh","Barh","Baripada Town","Barmer","Barnala","Barpeta","Batala","Bathinda","Begusarai","Belagavi","Bellampalle","Belonia","Bengaluru","Bettiah","BhabUrban Agglomeration","Bhadrachalam","Bhadrak","Bhagalpur","Bhainsa","Bharatpur","Bharuch","Bhatapara","Bhavnagar","Bhawanipatna","Bheemunipatnam","Bhilai Nagar","Bhilwara","Bhimavaram","Bhiwandi","Bhiwani","Bhongir","Bhopal","Bhubaneswar","Bhuj","Bikaner","Bilaspur","Bobbili","Bodhan","Bokaro Steel City","Bongaigaon City","Brahmapur","Buxar","Byasanagar","Chaibasa","Chalakudy","Chandausi","Chandigarh","Changanassery","Charkhi Dadri","Chatra","Chennai","Cherthala","Chhapra","Chhapra","Chikkamagaluru","Chilakaluripet","Chirala","Chirkunda","Chirmiri","Chittoor","Chittur-Thathamangalam","Coimbatore","Cuttack","Dalli-Rajhara","Darbhanga","Darjiling","Davanagere","Deesa","Dehradun","Dehri-on-Sone","Delhi","Deoghar","Dhamtari","Dhanbad","Dharmanagar","Dharmavaram","Dhenkanal","Dhoraji","Dhubri","Dhule","Dhuri","Dibrugarh","Dimapur","Diphu","Dumka","Dumraon","Durg","Eluru","English Bazar","Erode","Etawah","Faridabad","Faridkot","Farooqnagar","Fatehabad","Fatehpur Sikri","Fazilka","Firozabad","Firozpur Cantt.","Firozpur","Forbesganj","Gadwal","Gandhinagar","Gangarampur","Ganjbasoda","Gaya","Giridih","Goalpara","Gobichettipalayam","Gobindgarh","Godhra","Gohana","Gokak","Gooty","Gopalganj","Gudivada","Gudur","Gumia","Guntakal","Guntur","Gurdaspur","Gurgaon","Guruvayoor","Guwahati","Gwalior","Habra","Hajipur","Haldwani-cum-Kathgodam","Hansi","Hapur","Hardoi ","Hardwar","Hazaribag","Hindupur","Hisar","Hoshiarpur","Hubli-Dharwad","Hugli-Chinsurah","Hyderabad","Ichalkaranji","Imphal","Indore","Itarsi","Jabalpur","Jagdalpur","Jaggaiahpet","Jagraon","Jagtial","Jaipur","Jalandhar Cantt.","Jalandhar","Jalpaiguri","Jamalpur","Jammalamadugu","Jammu","Jamnagar","Jamshedpur","Jamui","Jangaon","Jatani","Jehanabad","Jhansi","Jhargram","Jharsuguda","Jhumri Tilaiya","Jind","Jodhpur","Jorhat","Kadapa","Kadi","Kadiri","Kagaznagar","Kailasahar","Kaithal","Kakinada","Kalimpong","Kalpi","Kalyan-Dombivali","Kamareddy","Kancheepuram","Kandukur","Kanhangad","Kannur","Kanpur","Kapadvanj","Kapurthala","Karaikal","Karimganj","Karimnagar","Karjat","Karnal","Karur","Karwar","Kasaragod","Kashipur","KathUrban Agglomeration","Katihar","Kavali","Kayamkulam","Kendrapara","Kendujhar","Keshod","Khair","Khambhat","Khammam","Khanna","Kharagpur","Kharar","Khowai","Kishanganj","Kochi","Kodungallur","Kohima","Kolar","Kolkata","Kollam","Koratla","Korba","Kot Kapura","Kota","Kothagudem","Kottayam","Kovvur","Koyilandy","Kozhikode","Kunnamkulam","Kurnool","Kyathampalle","Lachhmangarh","Ladnu","Ladwa","Lahar","Laharpur","Lakheri","Lakhimpur","Lakhisarai","Lakshmeshwar","Lal Gopalganj Nindaura","Lalganj","Lalganj","Lalgudi","Lalitpur","Lalsot","Lanka","Lar","Lathi","Latur","Lilong","Limbdi","Lingsugur","Loha","Lohardaga","Lonar","Lonavla","Longowal","Loni","Losal","Lucknow","Ludhiana","Lumding","Lunawada","Lunglei","Macherla","Machilipatnam","Madanapalle","Maddur","Madhepura","Madhubani","Madhugiri","Madhupur","Madikeri","Madurai","Magadi","Mahad","Mahalingapura","Maharajganj","Maharajpur","Mahasamund","Mahbubnagar","Mahe","Mahemdabad","Mahendragarh","Mahesana","Mahidpur","Mahnar Bazar","Mahuva","Maihar","Mainaguri","Makhdumpur","Makrana","Malaj Khand","Malappuram","Malavalli","Malda","Malegaon","Malerkotla","Malkangiri","Malkapur","Malout","Malpura","Malur","Manachanallur","Manasa","Manavadar","Manawar","Mancherial","Mandalgarh","Mandamarri","Mandapeta","Mandawa","Mandi Dabwali","Mandi","Mandideep","Mandla","Mandsaur","Mandvi","Mandya","Manendragarh","Maner","Mangaldoi","Mangaluru","Mangalvedhe","Manglaur","Mangrol","Mangrol","Mangrulpir","Manihari","Manjlegaon","Mankachar","Manmad","Mansa","Mansa","Manuguru","Manvi","Manwath","Mapusa","Margao","Margherita","Marhaura","Mariani","Marigaon","Markapur","Marmagao","Masaurhi","Mathabhanga","Mathura","Mattannur","Mauganj","Mavelikkara","Mavoor","Mayang Imphal","Medak","Medininagar (Daltonganj)","Medinipur","Meerut","Mehkar","Memari","Merta City","Mhaswad","Mhow Cantonment","Mhowgaon","Mihijam","Mira-Bhayandar","Mirganj","Miryalaguda","Modasa","Modinagar","Moga","Mohali","Mokameh","Mokokchung","Monoharpur","Moradabad","Morena","Morinda, India","Morshi","Morvi","Motihari","Motipur","Mount Abu","Mudabidri","Mudalagi","Muddebihal","Mudhol","Mukerian","Mukhed","Muktsar","Mul","Mulbagal","Multai","Mumbai","Mundargi","Mundi","Mungeli","Munger","Murliganj","Murshidabad","Murtijapur","Murwara (Katni)","Musabani","Mussoorie","Muvattupuzha","Muzaffarpur","Mysore","Nabadwip","Nabarangapur","Nabha","Nadbai","Nadiad","Nagaon","Nagapattinam","Nagar","Nagari","Nagarkurnool","Nagaur","Nagda","Nagercoil","Nagina","Nagla","Nagpur","Nahan","Naharlagun","Naidupet","Naihati","Naila Janjgir","Nainital","Nainpur","Najibabad","Nakodar","Nakur","Nalbari","Namagiripettai","Namakkal","Nanded-Waghala","Nandgaon","Nandivaram-Guduvancheri","Nandura","Nandurbar","Nandyal","Nangal","Nanjangud","Nanjikottai","Nanpara","Narasapuram","Narasaraopet","Naraura","Narayanpet","Nargund","Narkatiaganj","Narkhed","Narnaul","Narsinghgarh","Narsinghgarh","Narsipatnam","Narwana","Nashik","Nasirabad","Natham","Nathdwara","Naugachhia","Naugawan Sadat","Nautanwa","Navalgund","Navsari","Nawabganj","Nawada","Nawanshahr","Nawapur","Nedumangad","Neem-Ka-Thana","Neemuch","Nehtaur","Nelamangala","Nellikuppam","Nellore","Nepanagar","New Delhi","Neyveli (TS)","Neyyattinkara","Nidadavole","Nilambur","Nilanga","Nimbahera","Nirmal","Niwai","Niwari","Nizamabad","Nohar","Noida","Nokha","Nokha","Nongstoin","Noorpur","North Lakhimpur","Nowgong","Nowrozabad (Khodargama)","Nuzvid","O' Valley","Obra","Oddanchatram","Ongole","Orai","Osmanabad","Ottappalam","Ozar","P.N.Patti","Pachora","Pachore","Pacode","Padmanabhapuram","Padra","Padrauna","Paithan","Pakaur","Palacole","Palai","Palakkad","Palampur","Palani","Palanpur","Palasa Kasibugga","Palghar","Pali","Pali","Palia Kalan","Palitana","Palladam","Pallapatti","Pallikonda","Palwal","Palwancha","Panagar","Panagudi","Panaji","Panamattom","Panchkula","Panchla","Pandharkaoda","Pandharpur","Pandhurna","PandUrban Agglomeration","Panipat","Panna","Panniyannur","Panruti","Panvel","Pappinisseri","Paradip","Paramakudi","Parangipettai","Parasi","Paravoor","Parbhani","Pardi","Parlakhemundi","Parli","Partur","Parvathipuram","Pasan","Paschim Punropara","Pasighat","Patan","Pathanamthitta","Pathankot","Pathardi","Pathri","Patiala","Patna","Patratu","Pattamundai","Patti","Pattran","Pattukkottai","Patur","Pauni","Pauri","Pavagada","Pedana","Peddapuram","Pehowa","Pen","Perambalur","Peravurani","Peringathur","Perinthalmanna","Periyakulam","Periyasemur","Pernampattu","Perumbavoor","Petlad","Phagwara","Phalodi","Phaltan","Phillaur","Phulabani","Phulera","Phulpur","Phusro","Pihani","Pilani","Pilibanga","Pilibhit","Pilkhuwa","Pindwara","Pinjore","Pipar City","Pipariya","Piriyapatna","Piro","Pithampur","Pithapuram","Pithoragarh","Pollachi","Polur","Pondicherry","Ponnani","Ponneri","Ponnur","Porbandar","Porsa","Port Blair","Powayan","Prantij","Pratapgarh","Pratapgarh","Prithvipur","Proddatur","Pudukkottai","Pudupattinam","Pukhrayan","Pulgaon","Puliyankudi","Punalur","Punch","Pune","Punganur","Punjaipugalur","Puranpur","Puri","Purna","Purnia","PurqUrban Agglomerationzi","Purulia","Purwa","Pusad","Puthuppally","Puttur","Puttur","Qadian","Raayachuru","Rabkavi Banhatti","Radhanpur","Rae Bareli","Rafiganj","Raghogarh-Vijaypur","Raghunathganj","Raghunathpur","Rahatgarh","Rahuri","Raiganj","Raigarh","Raikot","Raipur","Rairangpur","Raisen","Raisinghnagar","Rajagangapur","Rajahmundry","Rajakhera","Rajaldesar","Rajam","Rajampet","Rajapalayam","Rajauri","Rajgarh (Alwar)","Rajgarh (Churu)","Rajgarh","Rajgir","Rajkot","Rajnandgaon","Rajpipla","Rajpura","Rajsamand","Rajula","Rajura","Ramachandrapuram","Ramagundam","Ramanagaram","Ramanathapuram","Ramdurg","Rameshwaram","Ramganj Mandi","Ramgarh","Ramnagar","Ramnagar","Ramngarh","Rampur Maniharan","Rampur","Rampura Phul","Rampurhat","Ramtek","Ranaghat","Ranavav","Ranchi","Ranebennuru","Rangia","Rania","Ranibennur","Ranipet","Rapar","Rasipuram","Rasra","Ratangarh","Rath","Ratia","Ratlam","Ratnagiri","Rau","Raurkela","Raver","Rawatbhata","Rawatsar","Raxaul Bazar","Rayachoti","Rayadurg","Rayagada","Reengus","Rehli","Renigunta","Renukoot","Reoti","Repalle","Revelganj","Rewa","Rewari","Rishikesh","Risod","Robertsganj","Robertson Pet","Rohtak","Ron","Roorkee","Rosera","Rudauli","Rudrapur","Rudrapur","Rupnagar","Sabalgarh","Sadabad","Sadalagi","Sadasivpet","Sadri","Sadulpur","Sadulshahar","Safidon","Safipur","Sagar","Sagara","Sagwara","Saharanpur","Saharsa","Sahaspur","Sahaswan","Sahawar","Sahibganj","Sahjanwa","Saidpur","Saiha","Sailu","Sainthia","Sakaleshapura","Sakti","Salaya","Salem","Salur","Samalkha","Samalkot","Samana","Samastipur","Sambalpur","Sambhal","Sambhar","Samdhan","Samthar","Sanand","Sanawad","Sanchore","Sandi","Sandila","Sanduru","Sangamner","Sangareddy","Sangaria","Sangli","Sangole","Sangrur","Sankarankovil","Sankari","Sankeshwara","Santipur","Sarangpur","Sardarshahar","Sardhana","Sarni","Sarsod","Sasaram","Sasvad","Satana","Satara","Sathyamangalam","Satna","Sattenapalle","Sattur","Saunda","Saundatti-Yellamma","Sausar","Savanur","Savarkundla","Savner","Sawai Madhopur","Sawantwadi","Sedam","Sehore","Sendhwa","Seohara","Seoni","Seoni-Malwa","Shahabad","Shahabad, Hardoi","Shahabad, Rampur","Shahade","Shahbad","Shahdol","Shahganj","Shahjahanpur","Shahpur","Shahpura","Shahpura","Shajapur","Shamgarh","Shamli","Shamsabad, Agra","Shamsabad, Farrukhabad","Shegaon","Sheikhpura","Shendurjana","Shenkottai","Sheoganj","Sheohar","Sheopur","Sherghati","Sherkot","Shiggaon","Shikaripur","Shikarpur, Bulandshahr","Shikohabad","Shillong","Shimla","Shirdi","Shirpur-Warwade","Shirur","Shishgarh","Shivamogga","Shivpuri","Sholavandan","Sholingur","Shoranur","Shrigonda","Shrirampur","Shrirangapattana","Shujalpur","Siana","Sibsagar","Siddipet","Sidhi","Sidhpur","Sidlaghatta","Sihor","Sihora","Sikanderpur","Sikandra Rao","Sikandrabad","Sikar","Silao","Silapathar","Silchar","Siliguri","Sillod","Silvassa","Simdega","Sindagi","Sindhagi","Sindhnur","Singrauli","Sinnar","Sira","Sircilla","Sirhind Fatehgarh Sahib","Sirkali","Sirohi","Sironj","Sirsa","Sirsaganj","Sirsi","Sirsi","Siruguppa","Sitamarhi","Sitapur","Sitarganj","Sivaganga","Sivagiri","Sivakasi","Siwan","Sohagpur","Sohna","Sojat","Solan","Solapur","Sonamukhi","Sonepur","Songadh","Sonipat","Sopore","Soro","Soron","Soyagaon","Sri Madhopur","Srikakulam","Srikalahasti","Srinagar","Srinagar","Srinivaspur","Srirampore","Srisailam Project (Right Flank Colony) Township","Srivilliputhur","Sugauli","Sujangarh","Sujanpur","Sullurpeta","Sultanganj","Sultanpur","Sumerpur","Sumerpur","Sunabeda","Sunam","Sundargarh","Sundarnagar","Supaul","Surandai","Surapura","Surat","Suratgarh","SUrban Agglomerationr","Suri","Suriyampalayam","Suryapet","Tadepalligudem","Tadpatri","Takhatgarh","Taki","Talaja","Talcher","Talegaon Dabhade","Talikota","Taliparamba","Talode","Talwara","Tamluk","Tanda","Tandur","Tanuku","Tarakeswar","Tarana","Taranagar","Taraori","Tarbha","Tarikere","Tarn Taran","Tasgaon","Tehri","Tekkalakote","Tenali","Tenkasi","Tenu dam-cum-Kathhara","Terdal","Tezpur","Thakurdwara","Thammampatti","Thana Bhawan","Thane","Thanesar","Thangadh","Thanjavur","Tharad","Tharamangalam","Tharangambadi","Theni Allinagaram","Thirumangalam","Thirupuvanam","Thiruthuraipoondi","Thiruvalla","Thiruvallur","Thiruvananthapuram","Thiruvarur","Thodupuzha","Thoubal","Thrissur","Thuraiyur","Tikamgarh","Tilda Newra","Tilhar","Tindivanam","Tinsukia","Tiptur","Tirora","Tiruchendur","Tiruchengode","Tiruchirappalli","Tirukalukundram","Tirukkoyilur","Tirunelveli","Tirupathur","Tirupathur","Tirupati","Tiruppur","Tirur","Tiruttani","Tiruvannamalai","Tiruvethipuram","Tiruvuru","Tirwaganj","Titlagarh","Tittakudi","Todabhim","Todaraisingh","Tohana","Tonk","Tuensang","Tuljapur","Tulsipur","Tumkur","Tumsar","Tundla","Tuni","Tura","Uchgaon","Udaipur","Udaipur","Udaipurwati","Udgir","Udhagamandalam","Udhampur","Udumalaipettai","Udupi","Ujhani","Ujjain","Umarga","Umaria","Umarkhed","Umbergaon","Umred","Umreth","Una","Unjha","Unnamalaikadai","Unnao","Upleta","Uran Islampur","Uran","Uravakonda","Urmar Tanda","Usilampatti","Uthamapalayam","Uthiramerur","Utraula","Vadakkuvalliyur","Vadalur","Vadgaon Kasba","Vadipatti","Vadnagar","Vadodara","Vaijapur","Vaikom","Valparai","Valsad","Vandavasi","Vaniyambadi","Vapi","Vapi","Varanasi","Varkala","Vasai-Virar","Vatakara","Vedaranyam","Vellakoil","Vellore","Venkatagiri","Veraval","Vidisha","Vijainagar, Ajmer","Vijapur","Vijayapura","Vijayawada","Vijaypur","Vikarabad","Vikramasingapuram","Viluppuram","Vinukonda","Viramgam","Virudhachalam","Virudhunagar","Visakhapatnam","Visnagar","Viswanatham","Vita","Vizianagaram","Vrindavan","Vyara","Wadgaon Road","Wadhwan","Wadi","Wai","Wanaparthy","Wani","Wankaner","Wara Seoni","Warangal","Wardha","Warhapur","Warisaliganj","Warora","Warud","Washim","Wokha","Yadgir","Yamunanagar","Yanam","Yavatmal","Yawal","Yellandu","Yemmiganur","Yerraguntla","Yevla","Zaidpur","Zamania","Zira","Zirakpur","Zunheboto"};

        editTextName = findViewById(R.id.edit_text_name);
        editTextDOB = findViewById(R.id.edit_text_dob);
        spinner = findViewById(R.id.spinnerspeciality);
        AutoCompleteTextView cities=findViewById(R.id.edit_text_city);
        editTextDOB.setOnClickListener(this);
        String[] speciality_list = getResources().getStringArray(R.array.array_speciality);
        ArrayAdapter<String> SpecialityAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, speciality_list);
        spinner.setAdapter(SpecialityAdapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, listOfCities);
        cities.setThreshold(1);
        cities.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_fs_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_fs:
                saveFS();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    int count;// should fetch latest dcr number from firebase and store in count

    int getCount() {
        count++;
        return count;
    }

    private void saveFS() {
        String name = editTextName.getText().toString();
        int FSCode = getCount();

        if (name.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a value", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference doctorbookRef = FirebaseFirestore.getInstance()
                .collection("FSBook");
        doctorbookRef.add(new FS(name, FSCode));
        Toast.makeText(this, "FS added", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View view) {
        editTextDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate();
            }
        });
    }

    private void pickDate() {
        int date, month, year;
        final Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                editTextDOB.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
            }
        }, date, month, year);
        datePickerDialog.show();

    }
}
