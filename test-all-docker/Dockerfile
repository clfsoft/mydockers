FROM alpine:3.19.4
RUN apk update  && apk upgrade && apk add --no-cache tzdata   \ 
    mariadb-client \
    postgresql13-client \
    net-tools bash \
    vim git build-base ca-certificates libc6-compat \
    wget curl jq nushell bind-tools \
    go ruby openjdk21 python3 nodejs 


# libc6-compat 解决nodejs执行  required file not found
# TODO multiple version
ENV VER_JAVA=21.0.2+13
COPY ./init /opt/init
RUN cat /opt/init/vfox-install.sh | bash
RUN echo 'eval "$(vfox activate bash)"' >> ~/.bashrc
RUN vfox add nodejs golang java php ruby python maven gradle terraform
RUN vfox install nodejs@21.7.3 java@23.0-graal java@${VER_JAVA maven@3.9.9 gradle@8.10.2 ruby@v3.3.4 golang@1.23.1 php@8.3.10 python@3.14.0 terraform@1.9.6
# ENV JAVA_HOME=~/.version-fox/cache/java/v-${VER_JAVA}
#20240925


ENV TZ=Asia/Tokyo

CMD ["/bin/bash"]

# 基本上面是一段时间使用后更新这个文件。
# git pull && docker build . -t clftool
# docker run --tty --detach --privileged --name clftool --volume=./data:/opt/data clftool
# docker exec -it clftool /bin/bash
# docker stop clftool && docker container prune