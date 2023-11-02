package com.example.comic_book;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class ViewHolder2 extends RecyclerView.ViewHolder {

    View mView1;
    SimpleExoPlayer exoPlayer2;
    private PlayerView mExoplayerView1;

    public ViewHolder2(@NonNull View itemView) {
        super(itemView);
        mView1 = itemView;
    }


    public void setVideo1 (final Application ctx, String title1, final String url1){
        TextView mtextView = mView1.findViewById(R.id.Titletv1);
        mExoplayerView1 = mView1.findViewById(R.id.exoplayer_view2);

        mtextView.setText(title1);
        try {
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter.Builder(ctx).build();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer2 = (SimpleExoPlayer) ExoPlayerFactory.newSimpleInstance(ctx);
            Uri video = Uri.parse(url1);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("Video2");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(video,dataSourceFactory,extractorsFactory,null,null);
            mExoplayerView1.setPlayer(exoPlayer2);
            exoPlayer2.prepare(mediaSource);
            exoPlayer2.setPlayWhenReady(false);
        }catch (Exception e){
            Log.e("ViewHolder2","exoplayer Error" +e.toString());
        }
    }

}
