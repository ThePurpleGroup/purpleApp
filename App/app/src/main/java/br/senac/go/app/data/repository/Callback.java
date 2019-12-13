package br.senac.go.app.data.repository;

public interface Callback<ResultType> {

        void onResult(ResultType result);

        void onError(Exception e);

        void onEmpty();


}
