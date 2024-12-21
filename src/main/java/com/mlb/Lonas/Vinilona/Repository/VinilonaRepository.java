package com.mlb.Lonas.Vinilona.Repository;

import com.mlb.Lonas.Vinilona.Model.VinilonaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VinilonaRepository extends JpaRepository<VinilonaModel,Long> {
    List<VinilonaModel> findByComprimentoAndLargura(double comprimento,double largura);
    // Cria um metodo para buscar o comprimento e a largura
    // Os nomes devem ser os MESMOS que estao na CLASSE MODEL
    // E como eu quero fazer isso utilizando 2 paramentros
    // É preciso usar And depois do primeiro parametro


}
