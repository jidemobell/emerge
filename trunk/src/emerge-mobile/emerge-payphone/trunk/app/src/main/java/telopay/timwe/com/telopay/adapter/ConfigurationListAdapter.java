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

public class ConfigurationListAdapter extends ArrayAdapter<String> {


    private static class ViewHolder {
        public final LinearLayout rootView;
        public final TextView tvConfigItem;

        private ViewHolder(LinearLayout rootView, TextView tvConfigItem) {
            this.rootView = rootView;
            this.tvConfigItem = tvConfigItem;
        }

        public static ViewHolder create(LinearLayout rootView) {
            TextView tvConfigItem = (TextView)rootView.findViewById( R.id.tvConfigItem );
            return new ViewHolder( rootView, tvConfigItem );
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if ( convertView == null ) {
            View view = mInflater.inflate( R.layout.configuration_list_item, parent, false );
            vh = ViewHolder.create( (LinearLayout)view );
            view.setTag( vh );
        } else {
            vh = (ViewHolder)convertView.getTag();
        }

        String item = getItem( position );
        vh.tvConfigItem.setText(item);
        // TODOBind your data to the views here

        return vh.rootView;
    }

    private LayoutInflater mInflater;

    // Constructors
    public ConfigurationListAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
        this.mInflater = LayoutInflater.from( context );
    }
    public ConfigurationListAdapter(Context context, String[] objects) {
        super(context, 0, objects);
        this.mInflater = LayoutInflater.from( context );
    }
}
