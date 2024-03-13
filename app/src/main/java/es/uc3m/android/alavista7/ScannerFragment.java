package es.uc3m.android.alavista7;
/*import android.app.Activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class ScannerFragment extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private String currentPhotoPath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_scanner, container, false);

        // Obtener referencia al botón desde el diseño inflado
        Button buttonFoto = rootView.findViewById(R.id.button_foto);

        // Configurar el clic del botón de foto
        buttonFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile = createImageFile();
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(requireContext(),
                            "es.uc3m.android.takepicture.provider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        return rootView;
    }

    private File createImageFile() {
        File image = null;
        try {
            DateFormat formatter = DateFormat.getDateTimeInstance();
            String currentDate = formatter.format(new Date());
            File storageDir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            image = File.createTempFile(currentDate, ".jpg", storageDir);
            currentPhotoPath = image.getAbsolutePath();
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "Exception creating file for image", e);
        }
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap miBitmap = BitmapFactory.decodeFile(currentPhotoPath);
            ImageView imageView = requireView().findViewById(R.id.image);
            imageView.setImageBitmap(miBitmap);

            TextView textView = requireView().findViewById(R.id.text_scanner);
            textView.setText(currentPhotoPath);
        }
    }

}*/



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class ScannerFragment extends Fragment {

    private String currentPhotoPath;

    private File createImageFile() {
        File image = null;
        try {
            DateFormat formatter = DateFormat.getDateTimeInstance();
            String currentDate = formatter.format(new Date());
            File storageDir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            image = File.createTempFile(currentDate, ".jpg", storageDir);
            currentPhotoPath = image.getAbsolutePath();
        } catch (IOException e) {
            Log.e(getClass().getSimpleName(), "Exception creating file for image", e);
        }
        return image;
    }
}

