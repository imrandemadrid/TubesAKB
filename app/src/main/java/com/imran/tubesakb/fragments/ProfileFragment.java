package com.imran.tubesakb.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.imran.tubesakb.MainActivity2;
import com.imran.tubesakb.R;
import com.imran.tubesakb.data.UsersModel;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private View view;
    private TextView email;
    private TextView nama;
    private TextView namaBawah;
    private TextView emailBawah;
    private LinearLayout linLogin;
    private NestedScrollView nesScrollMain;

    private Context context;

    // Perbuttonnan
    private Button btnLogin;
    private Button btnLogout;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public ProfileFragment() {
        // Required empty public constructor
    }
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //inisialisasi context biar bisa dipanggil dimana aja
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        email = view.findViewById(R.id.tv_emailUser_profile);
        emailBawah = view.findViewById(R.id.tv_emailUserBawah_profile);
        nama = view.findViewById(R.id.tv_nameUser_profile);
        namaBawah = view.findViewById(R.id.tv_namaUserBawah_profile);
        linLogin = view.findViewById(R.id.lin_login_profile);
        nesScrollMain = view.findViewById(R.id.nscroll_main_profile);

        // set button
        btnLogin = view.findViewById(R.id.btn_login_profile);
        btnLogout = view.findViewById(R.id.btn_logout_profile);
        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        checkUserLogin();
    }

    @Override
    public void onStart() {
        super.onStart();
        checkUserLogin();
    }

    //cek user login atau tidak
    private void checkUserLogin(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            getUserDataDariDatabase();
        }else{
            Intent intent = new Intent(context, MainActivity2.class);
            startActivity(intent);
            getActivity().finish();
        }
    }


    //ambil data user dari firebase
    private void getUserDataDariDatabase(){
        String userID = mAuth.getCurrentUser().getUid();
        CollectionReference usersRef = db.collection("users");
        usersRef.document(userID).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                UsersModel usersData = documentSnapshot.toObject(UsersModel.class);
                if(usersData != null){
                    updatetUserUI(usersData);
                }
            }
        });
    }


    //update tampilan berdasarkan database
    private void updatetUserUI(UsersModel usersModel){
        String userEmail = usersModel.getUserEmail();
        String userName = usersModel.getNama();
        email.setText(userEmail);
        emailBawah.setText(userEmail);
        nama.setText(userName);
        namaBawah.setText(userName);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login_profile:{
                Intent intent = new Intent(context, MainActivity2.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_logout_profile:{
                Toast.makeText(context,"logout",Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                checkUserLogin();
                break;
            }
        }
    }
}