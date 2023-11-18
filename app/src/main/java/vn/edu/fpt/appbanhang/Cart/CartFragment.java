package vn.edu.fpt.appbanhang.Cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.fpt.appbanhang.DienThoai.DienThoaiAdapter;
import vn.edu.fpt.appbanhang.DienThoai.DuLieuDT;
import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.Retrofit.MyRetrofit;
import vn.edu.fpt.appbanhang.SanPhamMoi.SanPhamMoiFragment;
import vn.edu.fpt.appbanhang.models.Cart;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
    }
    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();

        return fragment;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private RecyclerView recyclerView ;
    private CartAdapter adapter ;
    List<Cart> cartList ;
    TextView tv_tong ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.rcv_cart);
        tv_tong = view.findViewById(R.id.tv_tongTien);
        cartList = new ArrayList<Cart>();
        getListCart();




        return  view;
    }


    public void getListCart(){
        String id_user = "653913832367b0e5485fd324";
        MyRetrofit.api.getList(id_user).enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, Response<List<Cart>> response) {
                if (response.isSuccessful()){
                    cartList.clear();
                    cartList.addAll(response.body());
                    adapter = new CartAdapter(getActivity(),cartList);
                    LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                    double tong = 0 ;
                    for (Cart cart : cartList){
                        try {
                            tong += Double.parseDouble(cart.getId_sp().getGiasp());
                            Log.d("tongtien", "tongtien: "+tong);
                        }catch (NumberFormatException e){
                            e.printStackTrace();
                        }
                    }
                    DecimalFormat format  = new DecimalFormat("#");
                    String formatter = format.format(tong);
                    tv_tong.setText(formatter+"đ");
                }
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {

            }
        });


    }


}