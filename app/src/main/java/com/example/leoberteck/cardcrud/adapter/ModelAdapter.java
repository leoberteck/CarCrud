package com.example.leoberteck.cardcrud.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leoberteck.cardcrud.R;
import com.example.leoberteck.cardcrud.databinding.ModelViewHolderBinding;
import com.example.leoberteck.cardcrud.entity.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trovata on 29/07/2017.
 */

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelViewHolder> {

    private List<Model> modelList = new ArrayList<>();
    private IModelAdapterEventListener eventListener;

    public ModelAdapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ModelViewHolderBinding modelViewHolderBinding = DataBindingUtil.inflate(layoutInflater, R.layout.model_view_holder, parent, true);
        ModelViewHolder viewHolder = new ModelViewHolder(modelViewHolderBinding.getRoot());
        modelViewHolderBinding.setViewHolder(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ModelViewHolder holder, int position) {
        holder.setModel(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void notifyItemEditRequest(Model model){
        if(eventListener != null)
            eventListener.onItemEditRequest(model);
    }

    public void notifyItemRemoveRequest(Model model){
        if(eventListener != null)
            eventListener.onItemRemoveRequest(model);
    }

    public IModelAdapterEventListener getEventListener() {
        return eventListener;
    }

    public void setEventListener(IModelAdapterEventListener eventListener) {
        this.eventListener = eventListener;
    }

    public interface IModelAdapterEventListener {
        void onItemEditRequest(Model model);
        void onItemRemoveRequest(Model model);
    }

    public class ModelViewHolder extends RecyclerView.ViewHolder{

        public ObservableField<String> ModelName = new ObservableField<>();
        public ObservableField<String> BrandName = new ObservableField<>();
        public ObservableDouble Price = new ObservableDouble();

        private Model model;

        public ModelViewHolder(View itemView) {
            super(itemView);
        }

        public void onEditClick(){
            notifyItemEditRequest(getModel());
        }

        public void setModel(Model model){
            this.model = model;
            ModelName.set(model.getName());
            BrandName.set(model.getBrand().getName());
            Price.set(model.getPrice());
        }

        public Model getModel() {
            return model;
        }
    }
}
