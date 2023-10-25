package vn.edu.fpt.appbanhang.LienHe;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.fpt.appbanhang.R;
import vn.edu.fpt.appbanhang.SanPhamYeuThich.Message;
import vn.edu.fpt.appbanhang.SanPhamYeuThich.MessageAdapter;
import vn.edu.fpt.appbanhang.models.ChatBot;


public class Chat_bot_Fragment extends Fragment {
    private MessageAdapter messageAdapter;
    private ChatBot chatBot;
    private Spinner spinnerQuestionList;

    public static Chat_bot_Fragment newInstance() {
        return new Chat_bot_Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_bot, container, false);

        // Khởi tạo RecyclerView và MessageAdapter
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        messageAdapter = new MessageAdapter();
        recyclerView.setAdapter(messageAdapter);

        // Cấu hình RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Tạo đối tượng ChatBot
        chatBot = new ChatBot();

        // Khai báo spinnerQuestionList và ArrayAdapter
        spinnerQuestionList = view.findViewById(R.id.spinnerQuestionList);
        List<String> questionsList = chatBot.getQuestions();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, questionsList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerQuestionList.setAdapter(spinnerAdapter);

        // Khai báo btnSend và thiết lập sự kiện onClick
        Button btnSend = view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String selectedQuestion = spinnerQuestionList.getSelectedItem().toString();

                messageAdapter.addUserMessage(selectedQuestion);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String botResponse = chatBot.getResponse(selectedQuestion);
                        messageAdapter.addBotMessage(botResponse);
                    }
                }, 2000);

                spinnerQuestionList.setSelection(0);
            }
        });

        return view;
    }
}