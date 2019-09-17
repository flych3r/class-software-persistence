for $l in doc("livros.xml")//livro[autores/autor/nome = "Seu Jõao"]
return $l/titulo
