package telopay.timwe.com.telopay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import telopay.timwe.com.telopay.R;
import telopay.timwe.com.telopay.model.CallHistory;

public class PayphoneActivityListAdapter extends ArrayAdapter<CallHistory> {

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-11-10 17:40:47 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final LinearLayout rootView;
        public final TextView tvMobileNumber;
        public final TextView tvCallAmount;
        public final TextView tvCallTime;

        private ViewHolder(LinearLayout rootView, TextView tvMobileNumber, TextView tvCallAmount, TextView tvCallTime) {
            this.rootView = rootView;
            this.tvMobileNumber = tvMobileNumber;
            this.tvCallAmount = tvCallAmount;
            this.tvCallTime = tvCallTime;
        }

        public static ViewHolder create(LinearLayout rootView) {
            TextView tvMobileNumber = (TextView)rootView.findViewById( R.id.tvMobileNumber );
            TextView tvCallAmount = (TextView)rootView.findViewById( R.id.tvCallAmount );
            TextView tvCallTime = (TextView)rootView.findViewById( R.id.tvCallTime );
            return new ViewHolder( rootView, tvMobileNumber, tvCallAmount, tvCallTime );
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if ( convertView == null ) {
            View view = mInflater.inflate( R.layout.payphone_activity_list_item, parent, false );
            vh = ViewHolder.create( (LinearLayout)view );
            view.setTag( vh );
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        CallHistory item = getItem( position );

        vh.tvCallAmount.setText(item.getCallCost());
        vh.tvCallTime.setText(item.getCallDuration());
        vh.tvMobileNumber.setText(item.getDialNumber());

        return vh.rootView;
    }

    private LayoutInflater mInflater;

    // Constructors
    public PayphoneActivityListAdapter(Context context, List<CallHistory> objects) {
        super(context, 0, objects);
        this.mInflater = LayoutInflater.from( context );
    }
    public PayphoneActivityListAdapter(Context context, CallHistory[] objects) {
        super(context, 0, objects);
        this.mInflater = LayoutInflater.from( context );
    }
}
