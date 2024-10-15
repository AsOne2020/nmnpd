package me.asone.nmnpd.mixin;

import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientCommonNetworkHandler.class)
public class MixinClientCommonNetworkHandler {
    @Inject(method = "onPacketException", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientCommonNetworkHandler;savePacketErrorReport(Lnet/minecraft/network/packet/Packet;Ljava/lang/Throwable;)Ljava/util/Optional;"), cancellable = true)
    public void onPacketException(Packet packet, Exception exception, CallbackInfo ci) {
        ci.cancel();
    }
}
