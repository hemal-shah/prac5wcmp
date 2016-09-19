package hemal.mukesh.shah.practical5;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void largeNotification(View view) {
    Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(
      this,
      101,
      resultIntent,
      PendingIntent.FLAG_CANCEL_CURRENT
    );

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
      .setSmallIcon(R.mipmap.ic_launcher)
      .setContentTitle("Title")
      .setContentText("This is the content")
      .setSubText("The subtext is here!")
      .setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.big_string)));

    builder.setContentIntent(pendingIntent);

    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(10201, builder.build());
  }

  public void withButton(View view) {
    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    stackBuilder.addParentStack(ResultActivity.class);
    stackBuilder.addNextIntent(intent);
    PendingIntent pendingIntent = stackBuilder.getPendingIntent(1011, PendingIntent.FLAG_CANCEL_CURRENT);


    NotificationCompat.Builder builder =
      new NotificationCompat.Builder(this)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle("Buttons")
        .setContentText("You can call and email.")
        .addAction(android.R.drawable.sym_action_call, "Call", pendingIntent)
        .addAction(android.R.drawable.sym_action_email, "Email", pendingIntent);

    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(1212, builder.build());
  }

  public void simple(View view) {
    NotificationCompat.Builder builder =
      new NotificationCompat.Builder(this)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle("Simple Notification")
        .setContentText("Text");

    Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    stackBuilder.addParentStack(ResultActivity.class);
    stackBuilder.addNextIntent(resultIntent);

    PendingIntent pendingIntent = stackBuilder.getPendingIntent(
      101,
      PendingIntent.FLAG_CANCEL_CURRENT
    );

    builder.setContentIntent(pendingIntent);
    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(2002, builder.build());
  }
}
