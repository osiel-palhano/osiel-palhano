<!DOCTYPE html>
<html lang="pt-br">

<head>

	<title>Login Facebook</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/style.css
	">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<!--tags para SEO-->
	<meta name="description" content="Exemplo de descrição para o meu site.">
	<meta name="keywords" content="palavras-chaves,separada,por,virgula">
	<meta name="author" content="Osiel Palhano">

</head>
	<body>

		<header>
			<div class="center">
				
				<div class="logo">
					<h2>facebook</h2>
				</div><!--logo-->

				<form method="post" class="form-login">
					<div class="form-element">
						<p>E-mail ou telefone</p>
						<input type="email" name="login" required="">
					</div><!-- form-element  -->

					<div class="form-element">
						<p>Senha</p>
						<input type="password" name="senha" required="">
					</div><!-- form-element  --> 

					<div class="form-element">
						<input type="submit" name="acao" value="Entrar">
					</div><!-- form-element  --> 

					<div class="form-element-link">
						<link href=""><p>Esqueceu a conta?</p></link>
					</div><!-- form-element  --> 
				</form><!-- form-login  -->
					<div class="clear"></div><!-- clear  -->
			</div><!--center-->
		</header>

		<section class="main">
				<div class="center">
					<div class="text-1">
						<h4>O Facebook ajuda você a se conectar e<br>
							compartilhar com as pessoas que fazem parte<br> da sua vida.</h4>
					</div>
					<div class="img-pessoas">
						<img src="images/img1.png">
					</div><!--img-pessoas-->

					<div class="abrir-conta">

						<h2>Abra uma conta</h2>
						<h3>É rápido e fácil.</h3>

						<form class="criar-conta">
							<div class="w50">
								<input type="text" name="nome" placeholder="Nome" required="">
							</div><!--w50-->

							<div class="w50">
								<input type="text" name="Sobrenome" placeholder="Sobrenome" required="">
							</div><!--w50-->

							<div class="w100">
								<input type="email" name="email" placeholder="E-mail ou Telefone" required="">
							</div><!--w100-->

							<div class="w100">
								<input type="password" name="senha" placeholder="Nova senha" required="">
							</div><!--w100-->
							
							<div class="w100">

								<h3>Data de nascimento</h3>

								<select class="nascimento" name="nascimento-dia">
									<?php
										for($i = 1; $i <= 31; $i++){
									?>
									<option value="<?php echo $i; ?>"><?php echo $i; ?></option>
									<?php } ?>
								</select>
								
								<select class="nascimento" name="nascimento-mes">

									<option value="1">Janeiro</option>
									<option value="2">Fevereiro</option>
									<option value="3">Março</option>
									<option value="4">Abril</option>
									<option value="5">Maio</option>
									<option value="6">Junho</option>
									<option value="7">Julho</option>
									<option value="8">Agosto</option>
									<option value="9">Setembro</option>
									<option value="10">Outubro</option>
									<option value="11">Novembro</option>
									<option value="12">Dezembro</option>

								</select>
								<select class="nascimento" name="nascimento-ano">
									<?php
										for($i = 1960; $i <= 2020; $i++){
									?>
									<option value="<?php echo $i; ?>"><?php echo $i; ?></option>
									<?php } ?>
								</select>
									<div class="clear"></div>
							</div><!--w100-->

							<div class="w100">
								
								<h3 class="arrumar">Gênero</h3>

									<div class="input-radio">
										<input type="radio" name="genero" value="feminino"><h3 >Feminino</h3>
									</div>

									<div class="input-radio">
										<input type="radio" name="genero" value="masculino"><h3 >Masculino</h3>
									</div>

									<div class="input-radio">
										<input type="radio" name="genero" value="personalizado"><h3>Personalizado</h3>
									</div>

										<div class="clear"></div>

							</div><!--w100-->

							<div class="w100">

								<p class="palavra"><strong>Ao clicar em Cadastre-se, você concorda com nossos <a href="">Termos</a>,<br> <a href=""> Política de Dados</a> e <a href=""> Política de Cookies</a>. Você pode receber<br> notificações por SMS e pode cancelar isso quando quiser.</strong></p>

							</div><!--w100-->
								<div class="clear"></div>
							<div class="w100">

								<input type="submit" name="acao" value="Cadastre-se">

								<p class="final-cad"><strong><a href="#">Criar uma Página</a>para uma celebridade, banda ou empresa.</strong></p>
								
							</div><!--w100-->

						</form><!--criar-conta-->
					</div><!--abrir-conta-->
						<div class="clear"></div>
				</div><!--center-->
		</section><!--main-->

		<section class="linguas">
			
			<div class="center">

				<a class="select-lingua" href="#">Português (Brasil)</a>
				<a href="#">Português (Brasil)</a>
				<a href="#">English (US)</a>
				<a href="#">Español</a>
				<a href="#">Français (France)</a>
				<a href="#">Italiano</a>
				<a href="#">Deutsch</a>
			
			</div><!--center-->

			<div style="border:0;" class="center">
				<div class="style">
					<a href="#">Cadastre-se</a>
					<a href="#">Entrar</a>
					<a href="#">Messenger</a>
					<a href="#">Facebook Lite</a>
					<a href="#">watch</a>
					<a href="#">Pessoas</a>
					<a href="#">Páginas</a>
					<a href="#">Categorias de Páginas</a>
					<a href="#">Locais</a>
					<a href="#">Jogos</a>
					<a href="#">Locais</a>
					<a href="#">Marketplace</a>
					<a href="#">Facebook Pay</a><br>
					<a href="#">Grupos</a>
					<a href="#">Oculus</a>
					<a href="#">Portal</a>
					<a href="#">Instagram</a>
					<a href="#">Local</a>
					<a href="#">Campanhas de Arrecadação de Fundos</a>
					<a href="#">Serviços</a>
					<a href="#">Sobre</a>
					<a href="#">Criar Anúncio</a>
					<a href="#">Criar Página</a>
					<a href="#">Desenvolvedores</a>
					<a href="#">Carreiras</a><br>
					<a href="#">Privacidade</a>
					<a href="#">Cookies</a>
					<a href="#">Opções de Anúncio</a>
					<a href="#">Termos</a>
					<a href="#">Ajuda</a>

					<p>Facebook @ 2020</p>
				</div><!--style-->

			</div><!--center-->
			
		</section><!--linguas-->

	</body>
</html>