package cm.ufop.br.atividade01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student> students = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students.add(new Student(1, "Joao Silva", "SI", 4, 5.6, "56465456"));
        students.add(new Student(2, "Laura Rocha", "EE", 2, 7.5, "5478978"));
        students.add(new Student(3, "Luiza Alves", "EP", 7, 7.9, "87897899"));
        students.add(new Student(4, "Paulo Souza", "EC", 5, 6.3, "51489789"));
        students.add(new Student(5, "Tais Silveira", "SI", 6, 9.1, "58789789"));


    }

    public void adiciona(View v) {
        Intent it = new Intent(this, DadosAluno.class);
        it.putExtra("students", students);
        it.putExtra("position", 0);
        it.putExtra("action", DadosAluno.ACTIVITY_ADD);

        startActivityForResult(it, DadosAluno.ACTIVITY_ADD);
    }

    public void lista(View v) {
        Intent it = new Intent(this, ListAlunos.class);
        it.putExtra("students", students);
        it.putExtra("position", 0);
        it.putExtra("action", DadosAluno.ACTIVITY_LIST);

        startActivityForResult(it, DadosAluno.ACTIVITY_LIST);
    }

    public void chamar(View v) {
        Intent it = new Intent(this, ListAlunos.class);
        it.putExtra("students", students);
        it.putExtra("position", 0);
        it.putExtra("action", DadosAluno.ACTIVITY_CALL);

        startActivityForResult(it, DadosAluno.ACTIVITY_CALL);
    }


}
