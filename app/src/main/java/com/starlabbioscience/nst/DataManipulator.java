/*
 * 주의 와 메모리를위한 소프트웨어입니다. 그
 * 것은 나쁜 생각이지만 어쨌든 그것을하고,
 * 나는 상사가 아니에요 :)
 */
package com.starlabbioscience.nst;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DataManipulator {
    private FirebaseDatabase UserDatabase;
    private DatabaseReference reference;
    private List<DATA> NST_DATA = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<DATA> NST_DATA, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public DataManipulator() {
        UserDatabase = FirebaseDatabase.getInstance();
        reference = UserDatabase.getReference("NST_DATA");
    }

    public void readData(final DataStatus dataStatus){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                NST_DATA.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    DATA data = keyNode.getValue(DATA.class);
                    NST_DATA.add(data);
                }
                dataStatus.DataIsLoaded(NST_DATA,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void addData(DATA nst_data, final DataStatus dataStatus){
        String key = reference.push().getKey();
        reference.child(key).setValue(nst_data)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        dataStatus.DataIsInserted();
                    }
                });
    }

}
