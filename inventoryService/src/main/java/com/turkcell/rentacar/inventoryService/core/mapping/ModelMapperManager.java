package com.turkcell.rentacar.inventoryService.core.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

//java repository görünce onun bir örneğini belleğe otomatik atıyor.ama bizim interfacelerimiz için aynı durum geçerli değil

//dependency injection ile eklenen her klas arkada newlenmesi için klasıın kendisine ya da interfacei implement eden klasa @servis annatationınını eklememiz gerekir
//injection ile eklenen normal klas da olabilir interface olmasına gerek yok yine de klasın kendisine @servis yazılmalı
@Service
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;//belleğimde bunun newlwnmiş halinin olması lazım

    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forResponse() {

        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
