package sahab.singh.samplecopy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.util.List;


public class messageAdaptor extends ArrayAdapter<messagedata> {

    public messageAdaptor(@NonNull Context context, int resource, @NonNull List<messagedata> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_message, parent, false);
        }
        TextView messageTextView = convertView.findViewById(R.id.messageTextView);
        messagedata message = getItem(position);
        messageTextView.setText(message.getName());
        return convertView;
    }
}
