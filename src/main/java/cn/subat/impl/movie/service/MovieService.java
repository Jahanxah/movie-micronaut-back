package cn.subat.impl.movie.service;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RabbitListener
@Introspected
public class MovieService {


}
