package br.com.branch.testes.Telas;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.branch.testes.DAO.DAOImagem;
import br.com.branch.testes.R;

public class TelaTrocaImagem extends AppCompatActivity {

    //private static final int PICK_IMAGE = 1234;
    int PICK_IMAGE;
    ImageView imageTest,imageTest2;
    String diretorio,diretorio2,nomearquivo;
    private final String DIRETORIO= "/data/data/br.com.branch.testes/files/";
    private final String NOME= "imgTest";
    private final String ARQUIVO=DIRETORIO+NOME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_troca_imagem);

        imageTest=findViewById(R.id.imgTest1);
        imageTest2=findViewById(R.id.imgTest2);

        recuperaimagem();


    }


    public void imageOnClick(View v)
    {

        AlertDialog.Builder opcao = new AlertDialog.Builder(this);
        opcao.setTitle("TESTES");
        opcao.setMessage("Opcês de imagem");
        opcao.setPositiveButton("FOTO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                //ABRIR A OPÇÃO PARA CAPTURAR AS IMAGNES PARA SEREM USADAS NO LOGIN
                PICK_IMAGE = 123;
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(Intent.createChooser(i,"Tire uma Foto"), PICK_IMAGE);
                // FIM DO TRECHO

            }
        });

        opcao.setNegativeButton("ARQUIVO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                PICK_IMAGE = 1234;
                Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i,"Selecione uma imagem"), PICK_IMAGE);

            }
        });

        opcao.show();

        //CRIA O DIRETÓRIO PARA SALVAR A IMAGEM NO CELULAR
            File criaDir = new File(DIRETORIO);

          //FIM DO CAMPO

        boolean b =criaDir.mkdir();
        if(b || criaDir.exists())
        {
            Toast.makeText(getApplicationContext(),"OK Criado ou ja existe",Toast.LENGTH_LONG).show();

        }else{ Toast.makeText(getApplicationContext(),"Deu Zica!",Toast.LENGTH_LONG).show(); }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode != TelaPrincipal.RESULT_CANCELED){



            if(requestCode == PICK_IMAGE){

                imageTest=findViewById(R.id.imgTest1);
                imageTest2=findViewById(R.id.imgTest2);

                Bitmap bitmap =(Bitmap) data.getExtras().get("data");
                imageTest.setImageBitmap(bitmap);

                try {

                    SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);


                    byte[] bytes = stream.toByteArray();
                    //nomearquivo = DIRETORIO+"projeto_foto_testes_"+formatoData.format(new Date());
                    nomearquivo = DIRETORIO+NOME;


                    FileOutputStream fos = new FileOutputStream(nomearquivo);
                    fos.write(bytes);
                    fos.close();
                    Toast.makeText(getApplicationContext(),"SALVOU FOTO",Toast.LENGTH_LONG).show();



                    File imgFile = new File(nomearquivo);

                    if(imgFile.exists())
                    {

                        Bitmap mybitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                        imageTest2.setImageBitmap(mybitmap);
                    }


                }catch (Exception e){e.printStackTrace();}


                }


            }

        if(requestCode == PICK_IMAGE){

            imageTest=findViewById(R.id.imgTest1);
            Uri selectedImage = data.getData();

            imageTest.setImageURI(selectedImage);


            }


        }



        public void recuperaimagem()
        {
            File imgFile = new File(ARQUIVO);

            if(imgFile.exists())
            {

                 Bitmap mybitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                 imageTest2.setImageBitmap(mybitmap);


            }else {

                //imageTest2.setImageResource(R.mipmap.ic_background);
            }

        }

    }

