package com.hanhy06.betterchat.mixin;

import com.hanhy06.betterchat.BetterChat;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {
    @Shadow public ServerPlayerEntity player;

    @ModifyVariable(method = "handleDecoratedMessage", at = @At(value = "HEAD"), ordinal = 0, argsOnly = true)
    private SignedMessage modifyDecoratedMessage(SignedMessage original) {
        return BetterChat.getChatHandler().handleChatMessage(player,original);
    }
}
