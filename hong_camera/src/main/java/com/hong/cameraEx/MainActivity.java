package com.hong.cameraEx;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	private static final int REQUEST_IMAGE_CAPTURE = 672;
	private String imageFilePath;
	private Uri photoUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 권한 체크
		TedPermission.create()
				.setPermissionListener(permissionListener)
				.setRationaleMessage("카메라 권한이 필요합니다")
				.setDeniedMessage("거부하셨습니다")
				.setPermissions(Manifest.permission.CAMERA,
						Manifest.permission.WRITE_EXTERNAL_STORAGE,
						Manifest.permission.READ_EXTERNAL_STORAGE)
				.check();

		findViewById(R.id.btn_capture).setOnClickListener(this::capture_image);
	}

	private PermissionListener permissionListener = new PermissionListener() {
		@Override
		public void onPermissionGranted() {
			Toast.makeText(MainActivity.this, "권한이 허용됨", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onPermissionDenied(List<String> deniedPermissions) {
			Toast.makeText(MainActivity.this, "권한이 거부됨\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
		}
	};

	private void capture_image(View view) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (intent.resolveActivity(getPackageManager()) != null) {
			File photoFile = null;
			try {
				photoFile = createImageFile();
			} catch (IOException e) {

			}

			if (photoFile != null) {
				photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
				startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
			}
		}
	}

	private File createImageFile() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = "TEST_" + timeStamp + "_";
		File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
		File image = File.createTempFile(
				imageFileName, ".jpg", storageDir);
		imageFilePath = image.getAbsolutePath();
		return image;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			Bitmap bitmap = BitmapFactory.decodeFile(imageFilePath);
			ExifInterface exif = null;

			try {
				exif = new ExifInterface(imageFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}

			int exifOrientation;
			int exifDegree;

			if (exif != null) {
				exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
				exifDegree = exifOrientationToDegrees(exifOrientation);
			} else {
				exifDegree = 0;
			}

			((ImageView) findViewById(R.id.image_result)).setImageBitmap(rotate(bitmap, exifDegree));
		}
	}

	private Bitmap rotate(Bitmap bitmap, int exifDegree) {
		Matrix matrix = new Matrix();
		matrix.postRotate(exifDegree);
		return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
	}

	private int exifOrientationToDegrees(int exifOrientation) {
		if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) return 90;
		if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) return 180;
		if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) return 270;
		return 0;
	}
}