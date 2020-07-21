package com.imran.tubesakb.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.imran.tubesakb.KategoriAdapter;
import com.imran.tubesakb.R;
import com.imran.tubesakb.data.DataModel;

import java.util.ArrayList;

public class LookbookFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Context appContext;
    private KategoriAdapter kategoriAdapter;
    private String mKategori;
    ArrayList<DataModel> dataArray = new ArrayList<DataModel>();

    Button btnBasic;
    Button btnCausal;
    Button btnStreatwear;
    Button btnFormal;
    Button btnVintage;
    Button btnSporty;
    Button btnAllKategori;

    public LookbookFragment() {
        // Required empty public constructor
    }


    public static LookbookFragment newInstance() {
        LookbookFragment fragment = new LookbookFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        appContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_lookbook, container, false);

        btnBasic = view.findViewById( R.id.btn_basic_home);
        btnCausal = view.findViewById( R.id.btn_casual_home);
        btnStreatwear = view.findViewById( R.id.btn_streatwaer_home);
        btnFormal = view.findViewById( R.id.btn_formal_home);
        btnVintage = view.findViewById( R.id.btn_vintage_home);
        btnSporty = view.findViewById( R.id.btn_sporty_home);
        btnAllKategori = view.findViewById(R.id.btn_allKategori_home);

        btnBasic.setOnClickListener(this);
        btnCausal.setOnClickListener(this);
        btnStreatwear.setOnClickListener(this);
        btnFormal.setOnClickListener(this);
        btnVintage.setOnClickListener(this);
        btnSporty.setOnClickListener(this);
        btnAllKategori.setOnClickListener(this);

        return view;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isiDataDummy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sortingDataDummy();
    }

    private void sortingDataDummy(){
        ArrayList<DataModel> dataBerdasarkanKategori = new ArrayList<DataModel>();

        dataBerdasarkanKategori.clear();
        if(mKategori == null){
            dataBerdasarkanKategori.addAll(dataArray);
        }
        else{
            for (int i = 0; i < dataArray.size(); i++){
                String kategoriDariDataDummy = dataArray.get(i).getKategoti();
                Log.w("asd",kategoriDariDataDummy);
                if (kategoriDariDataDummy == mKategori) {
                    dataBerdasarkanKategori.add(dataArray.get(i));
                }
            }
        }
        tampilinDataKeRecycler(dataBerdasarkanKategori);
    }


    // tampil data ke RecyclerView
    private void tampilinDataKeRecycler(ArrayList<DataModel> dataArray){
        kategoriAdapter = new KategoriAdapter();
        RecyclerView gambarRV = view.findViewById(R.id.rv_dataGambar_home);
        kategoriAdapter.kategoriAdapter(dataArray);
        gambarRV.setLayoutManager(new GridLayoutManager(appContext,2));
        gambarRV.setAdapter(kategoriAdapter);
    }


    //button kategori
    @Override
    public void onClick(View view) {
        btnBasic.setEnabled(true);
        btnCausal.setEnabled(true);
        btnStreatwear.setEnabled(true);
        btnFormal.setEnabled(true);
        btnVintage.setEnabled(true);
        btnSporty.setEnabled(true);
        btnAllKategori.setEnabled(true);

        switch (view.getId()){
            case R.id.btn_basic_home:{
                mKategori = "Basic";
                view.setEnabled(false);
                break;
            }
            case R.id.btn_casual_home:{
                mKategori = "Casual";
                view.setEnabled(false);
                break;
            }
            case R.id.btn_streatwaer_home:{
                mKategori = "Streatwear";
                view.setEnabled(false);
                break;
            }
            case R.id.btn_formal_home:{
                mKategori = "Formal";
                view.setEnabled(false);
                break;
            }
            case R.id.btn_vintage_home:{
                mKategori = "Vintage";
                view.setEnabled(false);
                break;
            }
            case R.id.btn_sporty_home:{
                mKategori = "Sporty";
                view.setEnabled(false);
                break;
            }
            default:{
                mKategori = null;
                view.setEnabled(false);
                break;
            }
        }
        sortingDataDummy();
    }

    private void isiDataDummy(){
        dataArray.add(
                new DataModel(
                        1,
                        "https://i.pinimg.com/474x/a5/e7/62/a5e762f091d7295d615183e9057f2d51.jpg",
                        "Image 1",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        2,
                        "https://i.pinimg.com/474x/9f/80/cd/9f80cd69f48c0ee374c32101625b5d75.jpg",
                        "Image 2",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        3,
                        "https://i.pinimg.com/474x/8b/3a/c0/8b3ac080777a2de5f5012d9aa7408001.jpg",
                        "Image 3",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        4,
                        "https://i.pinimg.com/474x/74/09/d0/7409d0f6cc5efc360a9f1f924391bcb1.jpg",
                        "Image 4",
                        "Basic"
                )
        );
        dataArray.add(
                new DataModel(
                        5,
                        "https://i.pinimg.com/474x/fb/86/c0/fb86c01ab00e75395f6d3a76523f4a5f.jpg",
                        "Image 5",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        6,
                        "https://i.pinimg.com/474x/82/88/a3/8288a3981a5c72ba40ece9a2779a3fd4.jpg",
                        "Image 6",
                        "Streatwear"
                )
        );
        dataArray.add(
                new DataModel(
                        7,
                        "https://i.pinimg.com/474x/ed/35/af/ed35af993465f4b9bd1d3c1c30ac8700.jpg",
                        "Image 7",
                        "Streatwear"
                )
        );
        dataArray.add(
                new DataModel(
                        8,
                        "https://i.pinimg.com/474x/cd/15/cc/cd15cc365f015b6b19cde6328c08b0ac.jpg",
                        "Image 8",
                        "Formal"
                )
        );
        dataArray.add(
                new DataModel(
                        9,
                        "https://i.pinimg.com/474x/8c/e2/8c/8ce28c7022d6fd159acbe1bf55c9b275.jpg",
                        "Image 9",
                        "Vintage"
                )
        );
        dataArray.add(
                new DataModel(
                        10,
                        "https://i.pinimg.com/474x/a3/c7/29/a3c729c9584325d349ca9455c6bfb6fe.jpg",
                        "Image 10",
                        "Vintage"
                )
        );
        dataArray.add(
                new DataModel(
                        11,
                        "https://i.pinimg.com/474x/16/67/95/166795527d67b7b3c38ef2d7c7809d44.jpg",
                        "Image 11",
                        "Vintage"
                )
        );
        dataArray.add(
                new DataModel(
                        12,
                        "https://i.pinimg.com/474x/44/36/71/44367194bdfd2e9973806a7092cca595.jpg",
                        "Image 12",
                        "Sporty"
                )
        );
        dataArray.add(
                new DataModel(
                        13,
                        "https://i.pinimg.com/474x/f8/8e/2c/f88e2cbb28226260ba2f30819e583f10.jpg",
                        "Image 13",
                        "Sporty"
                )
        );
        dataArray.add(
                new DataModel(
                        14,
                        "https://i.pinimg.com/474x/a8/76/90/a876903c781856e53c3678a4f458b6b2.jpg",
                        "Image 14",
                        "Sporty"
                )
        );
        dataArray.add(
                new DataModel(
                        15,
                        "https://i.pinimg.com/474x/00/59/7a/00597a61e28640db52b8130849550559.jpg",
                        "Image 15",
                        "Basic"
                )
        );
        dataArray.add(
                new DataModel(
                        16,
                        "https://i.pinimg.com/474x/16/37/93/16379355b664cd8517da1d95e113c8ce.jpg",
                        "Image 16",
                        "Basic"
                )
        );
        dataArray.add(
                new DataModel(
                        17,
                        "https://i.pinimg.com/474x/0c/61/0b/0c610b9e8574ed4b1a416acda6a389d6.jpg",
                        "Image 17",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        18,
                        "https://i.pinimg.com/474x/4e/bc/ed/4ebcedfa23ac185c4d24605817fa8ef4.jpg",
                        "Image 18",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        19,
                        "https://i.pinimg.com/474x/93/a5/1d/93a51df673e7d600732d0e357c6d1d08.jpg",
                        "Image 19",
                        "Casual"
                )
        );
        dataArray.add(
                new DataModel(
                        20,
                        "https://i.pinimg.com/474x/3c/b7/a9/3cb7a964b29bac74224d8f2a77f91e72.jpg",
                        "Image 20",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        21,
                        "https://i.pinimg.com/474x/a0/eb/a3/a0eba30e0e358925ab1368e8862d3e89.jpg",
                        "Image 21",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        22,
                        "https://i.pinimg.com/474x/5a/2b/49/5a2b49bdb8b0beef2a39b9ad1af87d8c.jpg",
                        "Image 22",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        23,
                        "https://i.pinimg.com/474x/fe/05/7e/fe057e3a421eb015e16269d97518499c.jpg",
                        "Image 23",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        24,
                        "https://i.pinimg.com/474x/1a/d7/03/1ad7034d2835d4a9330dbd7d602dbc88.jpg",
                        "Image 24",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        25,
                        "https://i.pinimg.com/474x/fc/60/af/fc60afe14ed976c47880a9dd171097a5.jpg",
                        "Image 25",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        26,
                        "https://i.pinimg.com/474x/6c/a2/dc/6ca2dc8c9fe9d416140fcbabf09c3f1c.jpg",
                        "Image 26",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        27,
                        "https://i.pinimg.com/474x/53/e0/d4/53e0d421e1bee0fbf1aa9aff37ff3381.jpg",
                        "Image 27",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        28,
                        "https://i.pinimg.com/474x/e4/e7/14/e4e7144a6f3cc52cee6edf3c912c5ddc.jpg",
                        "Image 28",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        29,
                        "https://i.pinimg.com/474x/69/98/0b/69980be509e97c9d140d9806280b421f.jpg",
                        "Image 29",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        30,
                        "https://i.pinimg.com/474x/5e/2a/0c/5e2a0cc0a8485bda1c1830a4fe9e9b4a.jpg",
                        "Image 30",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        31,
                        "https://i.pinimg.com/474x/c8/9f/51/c89f513f4dab49bee7921dde63a28cbd.jpg",
                        "Image 31",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        32,
                        "https://i.pinimg.com/474x/9a/f1/77/9af17787b74b1a5e93dab84418634400.jpg",
                        "Image 32",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        33,
                        "https://i.pinimg.com/474x/b0/64/07/b0640727702fdff3bffaf6fec38d3ab8.jpg",
                        "Image 33",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        34,
                        "https://i.pinimg.com/474x/f9/95/4a/f9954abcd5119c438a4ad903c284ac32.jpg",
                        "Image 34",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        35,
                        "https://i.pinimg.com/474x/35/a2/14/35a21400839dba62176dbcfaef741e2a.jpg",
                        "Image 35",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        36,
                        "https://i.pinimg.com/474x/63/28/35/632835cade245306eeb502e4a7ea36e2.jpg",
                        "Image 36",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        37,
                        "https://i.pinimg.com/474x/95/7f/e2/957fe2fd7d00ea5a5b87ebe77f390b0e.jpg",
                        "Image 37",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        38,
                        "https://i.pinimg.com/474x/75/20/aa/7520aa86ddb3925bd01511dc3ba52cd6.jpg",
                        "Image 38",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        39,
                        "https://i.pinimg.com/474x/b9/45/a4/b945a48c0e4b6ffa92d9505ae2fea198.jpg",
                        "Image 39",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        40,
                        "https://i.pinimg.com/474x/9b/87/af/9b87af5e58fa699f95051e4298f9f845.jpg",
                        "Image 40",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        41,
                        "https://i.pinimg.com/474x/19/ec/42/19ec4230951b91925e46d0a542a655be.jpg",
                        "Image 41",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        42,
                        "https://i.pinimg.com/474x/28/da/34/28da34f9c721b0ebce3a0046bc2f3848.jpg",
                        "Image 42",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        43,
                        "https://i.pinimg.com/474x/54/07/d2/5407d2cb31c75c8efbfb4c16349636f8.jpg",
                        "Image 43",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        44,
                        "https://i.pinimg.com/474x/9c/79/5e/9c795ee9979fed446ffcf7f2874b5589.jpg",
                        "Image 44",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        45,
                        "https://i.pinimg.com/474x/29/89/cd/2989cda79cf1b6c03d13446988e85553.jpg",
                        "Image 45",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        46,
                        "https://i.pinimg.com/474x/3f/e7/0d/3fe70dc5c6de93095a64983be58f6f1a.jpg",
                        "Image 46",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        47,
                        "https://i.pinimg.com/474x/67/0e/f4/670ef49e2f036ff792fccf01cd92e7c3.jpg",
                        "Image 47",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        48,
                        "https://i.pinimg.com/474x/43/d7/f1/43d7f1b6f95a94b5fbc4c19be500c2f0.jpg",
                        "Image 48",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        49,
                        "https://i.pinimg.com/474x/3b/d8/c5/3bd8c58baae32b5e97bc633b1cbbd93f.jpg",
                        "Image 49",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        50,
                        "https://i.pinimg.com/474x/b2/3d/c5/b23dc590950684213c012f26f4732682.jpg",
                        "Image 50",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        51,
                        "https://i.pinimg.com/474x/b7/4d/a7/b74da70c166fe314493ce211dc7cd9df.jpg",
                        "Image 51",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        52,
                        "https://i.pinimg.com/474x/06/9b/2d/069b2d0b8c99acc76564787a09407249.jpg",
                        "Image 52",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        53,
                        "https://i.pinimg.com/474x/3e/94/75/3e94754082791ed27f7ef2661aacdbf9.jpg",
                        "Image 53",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        54,
                        "https://i.pinimg.com/474x/c8/59/e2/c859e280a2980a67b3a566e26f7c955e.jpg",
                        "Image 54",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        55,
                        "https://i.pinimg.com/474x/e7/5a/fd/e75afdd02fdc89e0a0c5b9cf0d3fe87b.jpg",
                        "Image 55",
                        "Basic"
                )
        );dataArray.add(
                new DataModel(
                        56,
                        "https://i.pinimg.com/474x/77/9f/d0/779fd0df7a1ed61f1218d02154b5a010.jpg",
                        "Image 56",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        57,
                        "https://i.pinimg.com/474x/6d/90/82/6d9082f832145a924b4b6bcee8681288.jpg",
                        "Image 57",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        58,
                        "https://i.pinimg.com/474x/d3/f6/ad/d3f6ad1fffe72a2c5d0a8323c69e6fbc.jpg",
                        "Image 58",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        59,
                        "https://i.pinimg.com/474x/aa/08/03/aa08038c132a06405f21a525df2d1c62.jpg",
                        "Image 59",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        60,
                        "https://i.pinimg.com/474x/16/dc/99/16dc99cf6e22066cc780f7f3c7b1c112.jpg",
                        "Image 60",
                        "Formal"
                )
        );dataArray.add(
                new DataModel(
                        61,
                        "https://i.pinimg.com/474x/87/0a/7d/870a7d0b33914b09fafe266c6781e78f.jpg",
                        "Image 61",
                        "Casual"
                )
        );dataArray.add(
                new DataModel(
                        62,
                        "https://i.pinimg.com/474x/f9/95/4a/f9954abcd5119c438a4ad903c284ac32.jpg",
                        "Image 62",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        63,
                        "https://i.pinimg.com/474x/0f/3a/84/0f3a848e7615897387d9b90b7c6e35f1.jpg",
                        "Image 63",
                        "Vintage"
                )
        );;dataArray.add(
                new DataModel(
                        64,
                        "https://i.pinimg.com/474x/0b/01/d7/0b01d79fa9fe4152fd70b98e8cffd4f7.jpg",
                        "Image 64",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        65,
                        "https://i.pinimg.com/474x/2c/ab/9e/2cab9ecc536b55a58907fc566e473d6a.jpg",
                        "Image 65",
                        "Vintage"
                )
        );dataArray.add(
                new DataModel(
                        66,
                        "https://i.pinimg.com/474x/71/36/ef/7136ef74f4ed5224cb9b247d4bf28b4c.jpg",
                        "Image 66",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        67,
                        "https://i.pinimg.com/474x/83/d2/4b/83d24bcc07e0c4fef438de2d448d06be.jpg",
                        "Image 67",
                        "Sporty"
                )
        );dataArray.add(
                new DataModel(
                        68,
                        "https://i.pinimg.com/474x/77/b4/73/77b473ff514e586e2c6ae9cfe43efb44.jpg",
                        "Image 68",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        69,
                        "https://i.pinimg.com/474x/3b/ae/1b/3bae1b00a480f0b7c94f22c532aa0474.jpg",
                        "Image 69",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        70,
                        "https://i.pinimg.com/474x/95/03/b0/9503b02d579427f0080f1b690e2226b1.jpg",
                        "Image 70",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        71,
                        "https://i.pinimg.com/474x/68/05/3d/68053d8a1a6f6f633b68be7e79f0279d.jpg",
                        "Image 71",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        72,
                        "https://i.pinimg.com/474x/cd/d5/af/cdd5af26064191f11751bef8eb03feb8.jpg",
                        "Image 72",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        73,
                        "https://i.pinimg.com/474x/f3/33/96/f333963bc946390581e39f190563ee04.jpg",
                        "Image 73",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        74,
                        "https://i.pinimg.com/474x/f8/48/de/f848de3fa8bfef8e758770a4836e674b.jpg",
                        "Image 74",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        75,
                        "https://i.pinimg.com/474x/6d/4f/7f/6d4f7f3cdda782ee6aaf4d9673e38bfb.jpg",
                        "Image 75",
                        "Streatwear"
                )
        );dataArray.add(
                new DataModel(
                        76,
                        "https://i.pinimg.com/474x/7c/0a/db/7c0adbfe4c7a6a47ec031b56e12844b0.jpg",
                        "Image 76",
                        "Streatwear"
                )
        );
    }
}