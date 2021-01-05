package com.example.android.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Places extends Fragment {

    public Places() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.mainscreen_word_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Creating object of ArrayList to hold data inside it:
        ArrayList<DS> obj = new ArrayList<DS>();

        int[] image = {R.drawable.humayuns_tomb, R.drawable.lodi_gardens, R.drawable.qutubminar,
                R.drawable.safdurjung_tomb, R.drawable.isa_khan_tomb, R.drawable.red_fort,
                R.drawable.alai_darwaza, R.drawable.jama_maszid, R.drawable.diwan_i_am,
                R.drawable.tomb_of_imam_zamin, R.drawable.purana_quila, R.drawable.tughlaqabad_fort,
                R.drawable.jantar_mantar, R.drawable.india_gate};

        String[] place_name = {"Humayun’s Tomb", "Lodi Gardens", "Qutub Minar",
                "Safdarjung’s Tomb", "Isa Khan’s Tomb", "Red Fort (Lal Qila)",
                "Alai Darwaza", "Jama Masjid", "Diwan-i-Am",
                "Tomb of Imam Zamin", "Purana Qila (Old Fort)", "Tughlaqabad Fort",
                "Jantar Mantar", "India Gate"};

        String[] location = {"Mathura Road, opposite the Nizamuddin Dargah", "Lodhi Road, New Delhi", "Mehrauli",
                "Lodi Estate, New Delhi", "Nizamuddin, New Delhi", "Netaji Subhash Road Chandini Chowk, Old Delhi",
                "Qutub Minar Complex, Mehrauli, New Delhi", "Off Netaji Subhash Marg, west of Red Fort", "Netaji Subhash Road, Chandini Chowk, Delhi",
                "Qutub Minar Complex, Mehrauli, New Delhi", "Mathura Road (near Delhi Zoo), New Delhi", "Mehrauli-Badarpur Road, New Delhi",
                "Sansad Marg, New Delhi", "Rajpath Marg, India Gate, New Delhi"};


        String[] timing = { "Sunrise to sunset", "Sunrise to sunset", "Sunrise to sunset",
                "Sunrise to Sunset", "Sunrise to sunset", "Sunrise to sunset (Monday closed)",
                "Sunrise to sunset", "7 am to an hour before sunset (summer), 8am to an hour before sunset (winter).", "Sunrise to sunset (Monday closed)",
                "Sunrise to sunset", "5:30 am to 7 pm", "8 am to 6 pm",
                "Sunrise to sunset", "24-hours daily (some areas are not accessible to visitors after dark)"};


        String[] detail = {"A UNESCO World Heritage Site, Humayun’s Tomb is a stunning piece of Persian architecture built in the Mughal era. It was commissioned in 1526, nine years after Humayun’s death, by his widow Hamida Banu Begum. This beautiful monument is made of red sandstone.",
                "The Lodi Gardens is one of Delhi’s very popular tourist attractions. With monuments and tombs from the Lodi and the Sayyed dynasties, the Lodi Gardens has the tombs of Sikander Lodi and Muhammad Shah.",
                "This 73-meter high tower was built by Qutub-ud-Din Aibak in the year 1193. Built after the defeat of Delhi’s last Hindu ruler, the Qutub Minar was constructed to celebrate the Muslim supremacy in Delhi. It is the highest tower in India, with five levels and projecting balconies. The first three levels are made up of red sandstone and the last two of marble and sandstone.",
                "The Safdarjung’s Tomb is the grave of Safdarjung. This garden tomb was built in the year 1753-54 by his son, Shuja-ud-Daula. It has several small awnings, like the Moti Mahal, Jangli Mahal and Badsha Pasand.",
                "Isa Khan’s Tomb is located in the same compound as the Humayun’s Tomb. It was built in the 15th century. Isa khan was an Afghan noble in the courts of Sher Shah Suri.",
                "This enormous red sandstone fort is synonymous with Delhi and is a testimony of the glory of the Mughal Empire. Built in 1638 by Shah Jahan, it took around ten years to be completed.A UNESCO World Heritage Site, the Red Fort is octagonal in shape with walls adorned with flowers and calligraphy, typically in the style of beautiful Mughal era architecture.",
                "The Alai Darwaza was built by Allaudin Khilji in 1311 AD. It is the main entrance from the south side of the Quwwat-ul-Islam Mosque in the Qutub Minar compound. The entrance was constructed using red sandstone and decorated with white marble.The walls have beautiful inscription in the Nashk script. The Alai Darwaza, with beautiful arches and borders that look like lotus buds, is one of the first buildings in India that was built using an Islamic architectural style.",
                "The Jama Masjid is India’s largest mosque. With minarets on all four sides that reach the skies, Jama Masjid, Emperor Shah Jahan’s last architectural indulgence, was commissioned in 1650 and took six years to be built. The enormous courtyard of the Jama Masjid can hold around twenty-five thousand worshippers.The main prayer hall has a beautiful white ceiling and the entrance is decorated with high rising arches. There is a pool right in heart of the mosque that is used by the faithful for cleansings before prayer. Note that visitors are advised to dress modestly (shorts, short skirts or sleeveless tops are NOT allowed). Since it is a house of prayer, it is necessary to remove your shoes at the entrance.",
                "The Diwan-i-Am is located inside the Red Fort and this is where the Emperor would meet and address the common people.The hall is adorned with stucco work and it contains gold columns. This grand hall was also used for many state gatherings and celebrations.",
                "Located near the Alai Darwaza, in the Qutub Complex, is the tomb of Imam Zamin, a well-known Turkestani Imam. Imam Zamin was the Imam of the Quwwat-u-islam Mosque. He came to Delhi in the 15th century and lived in the Qutub Complex premises during the rule of Sikandar Lodi.It is a small tomb built with sandstone on an octagonal base; the interiors are festooned with white plaster and intricate jaali work.",
                "The Purana Qila, one of the oldest forts in India, was built by the Afghan King, Sher Shah Suri. The fort has three entrances: the Bada Darwaza, Humayun Gate and the Talaqi Gate. All the gates are double storey structures that were constructed using sandstone.The north and the south gate have beautiful pavilions, balconies and umbrellas that add to the beauty and the grandeur of the fort.",
                "Built in 1321 by the founder of the Tughlaq Dynasty, Ghiyas-ud-din-Tughlaq, the Tughlaqabad Fort is a massive stone structure that has walls that are around 10 to 15 metres high. This huge fort was abandoned in the year 1327. The fort initially had 52 gates, 13 out of which still remain.",
                "Situated in the heart of the city, India Gate is one of the most popular and well known monuments in India. It was designed by Edwin Lutyens. With lush green and well-manicured lawns around, the foundation of this historical structure was laid in 1920.",
                "It was unveiled in 1933 and dedicated to all the Indian soldiers of the British Army that were killed in World War I."};

        //filling up the obj:
        for(int i=0; i<place_name.length; i++) {
            obj.add(new DS(image[i], place_name[i], location[i], timing[i], detail[i]));
        }
        //Creating wordAdapter
        WordAdapter adapter = new WordAdapter(getActivity(), obj);

        ListView listView = view.findViewById(R.id.list_xml);
        //setting adapter with ListView
        listView.setAdapter(adapter);
    }
}