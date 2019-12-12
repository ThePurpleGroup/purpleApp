package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Abastecimento;
import br.senac.go.webservice.model.Relatorio;
import br.senac.go.webservice.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoResource {

    @Autowired
    private final AbastecimentoRepository abastecimentoDAO;

    public AbastecimentoResource(AbastecimentoRepository abastecimentoDAO) {
        this.abastecimentoDAO = abastecimentoDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(abastecimentoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAbastecimentoById(@PathVariable("id") Long id){
        Optional<Abastecimento> abastecimento = abastecimentoDAO.findById(id);

        return new ResponseEntity<>(abastecimento, HttpStatus.OK);
    }
    @RequestMapping("/veiculo/{id_veiculo}")
    public ResponseEntity<?> getVeiculo(@PathVariable("id_veiculo") Long id_veiculo){
        List<Abastecimento> abastecimentoList = abastecimentoDAO.findAllBy(id_veiculo);
        return new ResponseEntity<>(abastecimentoList, HttpStatus.OK);
    }

    @RequestMapping("relatorio/{id_veiculo}")
    public  ResponseEntity<?> getRelatorio(@PathVariable("id_veiculo") Long id_veiculo){
        List<Abastecimento> abastecimentoList = abastecimentoDAO.findAllBy(id_veiculo);

        Relatorio relatorio = new Relatorio();

        String postoMaisCaro = null;
        String postoMaisBarato = null;
        double valorUnitarioCaro = 0;K
        double valorUnitarioBatato = 0;
        double mediaVeiculo = 0;
        double totalLitros = 0;
        int odometroInicial = 0;
        int odometroFim = 0;
        int odometro = 0;

        for (Abastecimento lista : abastecimentoList) {

            if (valorUnitarioBatato == 0) {
                valorUnitarioBatato = lista.getValor_por_combustive();
                postoMaisBarato = lista.getNome_posto();
            } else {
                if (lista.getValor_por_combustive() <= valorUnitarioBatato) {
                    valorUnitarioBatato = lista.getValor_por_combustive();
                    postoMaisBarato = lista.getNome_posto();
                    totalLitros = lista.getTotal_litros();
                }
            }

            if (lista.getValor_por_combustive() > valorUnitarioCaro) {
                valorUnitarioCaro = lista.getValor_por_combustive();
                postoMaisCaro = lista.getNome_posto();

            }

            if (odometroInicial == 0) {
                odometroInicial = (int) lista.getOdometro();
            } else {
                if (lista.getOdometro() <= odometroInicial) {
                    odometroInicial = (int) lista.getOdometro();
                }
            }
            if (lista.getOdometro() > odometroFim) {
                odometroFim = (int) lista.getOdometro();
            }
        }
        if (odometroInicial != 0) {
            odometro = odometroFim - odometroInicial;
            mediaVeiculo = odometro / totalLitros;
        }

        relatorio.setId_veiculo(id_veiculo);
        relatorio.setPostoMaisBarato(postoMaisBarato);
        relatorio.setPostoMaisCaro(postoMaisCaro);
        relatorio.setMediaConsumo(mediaVeiculo);

        return new ResponseEntity<>(relatorio, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Abastecimento abastecimento){
        return new ResponseEntity<>(abastecimentoDAO.save(abastecimento), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        abastecimentoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Abastecimento abastecimento){
        abastecimentoDAO.save(abastecimento);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
