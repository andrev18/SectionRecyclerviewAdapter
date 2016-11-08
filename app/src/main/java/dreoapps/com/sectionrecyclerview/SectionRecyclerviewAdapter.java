package dreoapps.com.sectionrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by avlad18 on 11/8/2016.
 */

public abstract class SectionRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public abstract int getSectionsCount();

    public abstract int getItemCountForSection(int section);

    public abstract RecyclerView.ViewHolder onCreateViewHolderSection(ViewGroup parent, int section);

    public abstract RecyclerView.ViewHolder onCreateViewHolderForSection(ViewGroup parent, int section);

    public abstract void onBindViewHolderForSection(RecyclerView.ViewHolder holder, int position, int section);

    public abstract void onBindViewHolderSection(RecyclerView.ViewHolder holder, int section);


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        int calculatedPosition = -1;
        for (int section = 0; section < getSectionsCount(); section++) {
            calculatedPosition++;
            if (calculatedPosition == position) {
                return onCreateViewHolderSection(parent, section);
            }

            for (int items = 0; items < getItemCountForSection(section); items++) {
                calculatedPosition++;
                if (calculatedPosition == position) {
                    return onCreateViewHolderForSection(parent, section);
                }
            }
        }

        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int calculatedPosition = -1;

        for (int section = 0; section < getSectionsCount(); section++) {
            calculatedPosition++;
            if (calculatedPosition == position) {
                onBindViewHolderSection(holder, section);
                break;
            }

            for (int items = 0; items < getItemCountForSection(section); items++) {
                calculatedPosition++;
                if (calculatedPosition == position) {
                    onBindViewHolderForSection(holder, items, section);
                    return;
                }
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (int i = 0; i < getSectionsCount(); i++) {
            count++;
            for (int j = 0; j < getItemCountForSection(i); j++) {
                count++;
            }
        }
        return count;
    }
}

