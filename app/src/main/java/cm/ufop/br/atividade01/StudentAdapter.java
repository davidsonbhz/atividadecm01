package cm.ufop.br.atividade01;

/**
 * Created by George on 03/04/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private List<Student> list;

    public StudentAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        Student student = list.get(position);
        return student;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //Recovers the Student in the current position
        Student student = list.get(position);

        //Creates a View object from the given XML layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.student_detail, null);

        //Updates TextView’s text to the Student’s info
        TextView textId = (TextView) v.findViewById(R.id.det_id);
        textId.setText("" + student.id);
        TextView textName = (TextView) v.findViewById(R.id.det_name);
        textName.setText(student.name);
        TextView textCourse = (TextView) v.findViewById(R.id.det_course);
        textCourse.setText(student.course);
        TextView textPeriod = (TextView) v.findViewById(R.id.det_period);
        textPeriod.setText("" + student.period);
        TextView textCoefficient = (TextView) v.findViewById(R.id.det_coefficient);
        textCoefficient.setText("" + (double) student.coefficient);

        //Sets image of ImageView to the correct Student type
        ImageView img = (ImageView) v.findViewById(R.id.img);
        img.setImageResource(student.getImage());
        return v;
    }



}
