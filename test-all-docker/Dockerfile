FROM ubuntu:24.04
RUN apt update -y && apt -y install \
    build-essential vim git bash ca-certificates \
    iputils-ping net-tools wget curl jq \
    mariadb-client postgresql-client \
    
	 && echo "--install end--"

ENV TZ=Asia/Tokyo

# multiple version
#ENV VER_JAVA=21.0.2+13
COPY ./init /opt/init
RUN cat /opt/init/vfox-install.sh | bash
RUN echo 'eval "$(vfox activate bash)"' >> ~/.bashrc
RUN vfox add nodejs golang java php ruby python maven gradle terraform
RUN vfox install nodejs@21.7.3 java@23.0-graal java@${VER_JAVA} maven@3.9.9 gradle@8.10.2 ruby@v3.3.4 golang@1.23.1 php@8.3.10 python@3.14.0 terraform@1.9.6
#ENV JAVA_HOME=~/.version-fox/cache/java/current
#20240925


CMD ["/bin/bash"]

# 基本上面是一段时间使用后更新这个文件。
# git pull && docker build . -t clftool
# docker run --tty --detach --privileged --name clftool --volume=./data:/opt/data clftool
# docker exec -it clftool /bin/bash
# docker stop clftool && docker container prune